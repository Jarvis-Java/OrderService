package com.jarvis.orderservice.api.utils;

import java.util.Random;
import java.util.UUID;

import com.jarvis.orderservice.api.entity.Order;

public class OrderUtils {

	public static String generateTransactionId() {
		return UUID.randomUUID().toString();
	}

	public static String generateStatus() {
		return new Random().nextBoolean()?"Your Payment is Successfully Processed!":"Your Payment is Failed!";
	}

	public static Order getOrderErrorObject() {
		return new Order(0000,"Order Doesn't Exist!",0,0,"Order Doesn't Exist!","Order Doesn't Exist!");
	}
}
