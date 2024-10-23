package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.model.Order;
import com.store.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUser(User user);
}
