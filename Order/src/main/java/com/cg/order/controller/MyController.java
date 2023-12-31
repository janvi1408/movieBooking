package com.cg.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.order.alldto.CategoryDTO;
import com.cg.order.exception.InvalidCategoryId;
import com.cg.order.exception.InvalidOrderId;
import com.cg.order.exception.InvalidProductId;
import com.cg.order.model.Orders;
import com.cg.order.service.OrderService;

import jakarta.persistence.criteria.Order;

@RestController
public class MyController {
	@Autowired
	private OrderService orderService;
	
@PostMapping("/create")
public ResponseEntity<Orders> createOrder(@RequestBody Orders order){
	return new ResponseEntity<Orders>(orderService.create(order),HttpStatus.CREATED);
}

@GetMapping("/get/{orderId}")
public ResponseEntity<Orders> getOrder(@PathVariable int orderId)throws InvalidOrderId{
	return new ResponseEntity<Orders>(orderService.getById(orderId),HttpStatus.OK);
}
@GetMapping("/status/{categoryId}/{productId}/{quantity}/{ingredients}")
public ResponseEntity<String> statusOrder(@PathVariable int categoryId,@PathVariable int productId,@PathVariable int quantity,@PathVariable List<Integer>ingredients)throws InvalidCategoryId,InvalidProductId{
	return new ResponseEntity<String>(orderService.statusOrder(categoryId,productId,quantity,ingredients),HttpStatus.OK);
}

}
