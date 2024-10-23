package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.CartItemRequestDTO;
import com.store.dto.CartItemResponseDTO;
import com.store.dto.CartResponseDTO;
import com.store.model.Cart;
import com.store.model.CartItem;
import com.store.model.Product;
import com.store.model.User;
import com.store.repository.CartItemRepository;
import com.store.repository.CartRepository;
import com.store.repository.ProductRepository;
import com.store.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public CartResponseDTO getCartForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Cart cart = cartRepository.findByUser(user);

        return mapToCartResponseDTO(cart);
    }

    public CartResponseDTO addItemToCart(Long userId, CartItemRequestDTO request) {
        User user = userRepository.findById(userId).orElseThrow();
        Cart cart = cartRepository.findByUser(user);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

        Product product = productRepository.findById(request.getProductId()).orElseThrow();
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(request.getQuantity());

        cartItemRepository.save(cartItem);

        return mapToCartResponseDTO(cart);
    }

    public void removeItemFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    private CartResponseDTO mapToCartResponseDTO(Cart cart) {
        List<CartItemResponseDTO> cartItemDTOs = cart.getCartItems().stream().map(this::mapToCartItemDTO).collect(Collectors.toList());

        double totalPrice = cartItemDTOs.stream().mapToDouble(CartItemResponseDTO::getTotalPrice).sum();

        CartResponseDTO cartDTO = new CartResponseDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setCartItems(cartItemDTOs);
        cartDTO.setTotalPrice(totalPrice);

        return cartDTO;
    }

    private CartItemResponseDTO mapToCartItemDTO(CartItem cartItem) {
        CartItemResponseDTO dto = new CartItemResponseDTO();
        dto.setId(cartItem.getId());
        dto.setProductName(cartItem.getProduct().getName());
        dto.setQuantity(cartItem.getQuantity());
        dto.setProductPrice(cartItem.getProduct().getPrice());
        dto.setTotalPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
        return dto;
    }
}