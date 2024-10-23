package com.store.service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.OrderItemResponseDTO;
import com.store.dto.OrderRequestDTO;
import com.store.dto.OrderResponseDTO;
import com.store.model.Order;
import com.store.model.OrderItem;
import com.store.model.Product;
import com.store.model.User;
import com.store.repository.OrderRepository;
import com.store.repository.ProductRepository;
import com.store.repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderResponseDTO createOrder(OrderRequestDTO request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(new Date());

        List<OrderItem> orderItems = request.getOrderItems().stream().map(orderItemDTO -> {
            Product product = productRepository.findById(orderItemDTO.getProductId()).orElseThrow();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setPrice(product.getPrice() * orderItemDTO.getQuantity());

            return orderItem;
        }).collect(Collectors.toList());

        order.setOrderItems(orderItems);
        order.setTotalAmount(orderItems.stream().mapToDouble(OrderItem::getPrice).sum());

        orderRepository.save(order);

        return mapToOrderResponseDTO(order);
    }

    public List<OrderResponseDTO> getOrdersForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return orderRepository.findByUser(user).stream().map(this::mapToOrderResponseDTO).collect(Collectors.toList());
    }

    private OrderResponseDTO mapToOrderResponseDTO(Order order) {
        List<OrderItemResponseDTO> orderItemDTOs = order.getOrderItems().stream().map(orderItem -> {
            OrderItemResponseDTO dto = new OrderItemResponseDTO();
            dto.setProductId(orderItem.getProduct().getId());
            dto.setProductName(orderItem.getProduct().getName());
            dto.setQuantity(orderItem.getQuantity());
            dto.setPrice(orderItem.getPrice());
            return dto;
        }).collect(Collectors.toList());

        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setId(order.getId());
        responseDTO.setUserId(order.getUser().getId());
        responseDTO.setTotalAmount(order.getTotalAmount());
        responseDTO.setOrderDate(order.getOrderDate());
        responseDTO.setOrderItems(orderItemDTOs);

        return responseDTO;
    }
}