package com.jarvis.orderservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.orderservice.api.entity.Order;
import com.jarvis.orderservice.api.service.OrderService;

@RestController
@RequestMapping("/orderAPI")
public class OrderController {
	
	 @Autowired
	 private OrderService orderService;

	 
	 @PostMapping("/createOrder")
	 public Order createOrder(@RequestBody Order orderRequest){ 
		 return orderService.createOrder(orderRequest);
	 }
	
	 @GetMapping("/orders/{orderId}")
	 public Order getOrderById(@PathVariable("orderId") Long orderId){ 
		 return orderService.getOrderById(orderId);
	 }
	 
	 @GetMapping("/orders")
	 public List<Order> getAllOrders(){ 
		 return orderService.getAllOrders();
	 }
	 
	 @PutMapping("/orders/{orderId}")
	 public Order updateOrderById(@PathVariable("orderId") long orderId, @RequestBody Order order) {
		 return orderService.updateOrderById(orderId,order);
	 }
	 
	 @DeleteMapping("/orders/{orderId}")
	 public Order deleteOrderById(@PathVariable("orderId") Long orderId){ 
		 return orderService.deleteOrderById(orderId);
	 }
}
