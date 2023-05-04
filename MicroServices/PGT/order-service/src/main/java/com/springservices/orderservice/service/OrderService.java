package com.springservices.orderservice.service;

import com.springservices.orderservice.dto.InventoryResponse;
import com.springservices.orderservice.dto.OrderRequest;
import com.springservices.orderservice.model.Order;
import com.springservices.orderservice.model.OrderLineItems;
import com.springservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.stream;


@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class OrderService {

    private final ModelMapper mapper;

    private final OrderRepository orderRepository;

    private final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream().map(item -> mapper.map(item, OrderLineItems.class))
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = orderLineItems.stream().map(OrderLineItems::getSkuCode).toList();

        // call inventory service to verify that all the ordered items are in stock or not

        InventoryResponse[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:8083/api/inventory/",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean isAllProductsInStock = stream(inventoryResponseArray)
                .allMatch(InventoryResponse::getIsInStock);

        if (isAllProductsInStock){
            orderRepository.save(order);

            log.info("Order placed successfully");
        }else {
            // here we are throwing error without mentioning which product is out of stock. In production environment it is not recommended.
            throw new RuntimeException("product is out of stock please try again later in some time...");
        }



    }
}
