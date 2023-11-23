package com.springservices.orderservice.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsDtoList;

}
