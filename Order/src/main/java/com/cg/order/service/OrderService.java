package com.cg.order.service;

import java.util.List;

import com.cg.order.alldto.CategoryDTO;
import com.cg.order.alldto.ProductDTO;
import com.cg.order.exception.InvalidCategoryId;
import com.cg.order.exception.InvalidOrderId;
import com.cg.order.exception.InvalidProductId;
import com.cg.order.model.Orders;

import jakarta.persistence.criteria.Order;

public interface OrderService {
	
public Orders create(Orders order);
public String statusOrder(int categoryId,int productId,int quantity,List<Integer>ingredients)throws InvalidCategoryId,InvalidProductId ;
public Orders getById(int orderId)throws InvalidOrderId;
}
