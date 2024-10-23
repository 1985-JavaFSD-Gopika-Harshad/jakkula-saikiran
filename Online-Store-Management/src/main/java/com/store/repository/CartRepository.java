package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.model.Cart;
import com.store.model.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByUser(User user);
}
