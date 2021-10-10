package com.jarvis.orderservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.orderservice.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
