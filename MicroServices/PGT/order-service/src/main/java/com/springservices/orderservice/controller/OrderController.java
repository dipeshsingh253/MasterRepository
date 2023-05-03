package com.springservices.orderservice.controller;


import com.springservices.orderservice.dto.OrderRequest;
import com.springservices.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private final OrderService orderService;


    @PostMapping("/")
    @ResponseStatus(CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }

}
