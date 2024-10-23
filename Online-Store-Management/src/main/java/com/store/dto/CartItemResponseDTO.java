package com.store.dto;

import lombok.Data;

@Data
public class CartItemResponseDTO {
	    private Long id;
	    private String productName;
	    private Integer quantity;
	    private Double productPrice;
	    private Double totalPrice;
}
