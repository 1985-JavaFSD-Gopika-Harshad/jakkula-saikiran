package com.store.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private Long userId;
    private List<OrderItemRequestDTO> orderItems;
}