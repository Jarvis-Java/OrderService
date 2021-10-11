package com.jarvis.orderservice.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.orderservice.api.entity.Order;
import com.jarvis.orderservice.api.repository.OrderRepository;
import com.jarvis.orderservice.api.utils.OrderUtils;

@Service
public class OrderService {
	
	@Autowired
	public OrderRepository orderRepository;

	public Order createOrder(Order orderRequest) {
		orderRequest.setTransactionId(OrderUtils.generateTransactionId());
		orderRequest.setStatus(OrderUtils.generateStatus());
		return orderRepository.save(orderRequest);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(Long orderId) {
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		if(orderOptional.isPresent()){
			return orderOptional.get();
		} else{
			return OrderUtils.getOrderErrorObject();
		}
	}

	public Order updateOrderById(long orderId, Order order) {
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		if(orderOptional.isPresent()){
			Order orderData = orderOptional.get();
			orderData.setName(order.getName());
			orderData.setPrice(order.getPrice());
			orderData.setQuantity(order.getQuantity());
			orderRepository.save(orderData);
			return orderData;
		} else{
			return OrderUtils.getOrderErrorObject();
		}
	}

	//Hello 
	public Order deleteOrderById(Long orderId) {
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		if(orderOptional.isPresent()){
			 orderRepository.deleteById(orderId);
			 return orderOptional.get();
		} else{
			return OrderUtils.getOrderErrorObject();
		}
	}

}
