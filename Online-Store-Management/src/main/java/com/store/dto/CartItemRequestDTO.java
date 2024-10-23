package com.store.dto;

import lombok.Data;

@Data
public class CartItemRequestDTO {
	
	private Long productId;
    private Integer quantity;

}
