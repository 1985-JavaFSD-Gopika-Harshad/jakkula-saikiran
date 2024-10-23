package com.store.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderResponseDTO {
    private Long id;
    private Long userId;
    private Double totalAmount;
    private Date orderDate;
    private List<OrderItemResponseDTO> orderItems;
}