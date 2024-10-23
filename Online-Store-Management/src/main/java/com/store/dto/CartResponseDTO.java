package com.store.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartResponseDTO {
	
	private Long id;
    private List<CartItemResponseDTO> cartItems;
    private Double totalPrice;

}
