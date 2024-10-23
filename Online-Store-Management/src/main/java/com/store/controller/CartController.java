package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CartItemRequestDTO;
import com.store.dto.CartResponseDTO;
import com.store.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public CartResponseDTO getCart(@PathVariable Long userId) {
        return cartService.getCartForUser(userId);
    }

    @PostMapping("/{userId}/add")
    public CartResponseDTO addItemToCart(@PathVariable Long userId, @RequestBody CartItemRequestDTO request) {
        return cartService.addItemToCart(userId, request);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public void removeItemFromCart(@PathVariable Long cartItemId) {
        cartService.removeItemFromCart(cartItemId);
    }
}