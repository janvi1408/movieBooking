package com.cg.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.order.alldto.CategoryDTO;
import com.cg.order.alldto.IngredientsDTO;
import com.cg.order.alldto.ProductDTO;
import com.cg.order.exception.InvalidCategoryId;
import com.cg.order.exception.InvalidOrderId;
import com.cg.order.exception.InvalidProductId;
import com.cg.order.model.Orders;
import com.cg.order.repo.OrderRepo;

import jakarta.persistence.criteria.Order;

@Component
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepo repo;
	private RestTemplate restTemplate;
	
	public OrderServiceImpl(RestTemplate restTemplate) {
		 this.restTemplate = restTemplate;
	}
	public OrderServiceImpl() {
		
	}
	
	public CategoryDTO findByCategory(int categoryId) throws InvalidCategoryId {
		// TODO Auto-generated method stub
		try {
		
		   return restTemplate.getForEntity("http://localhost:9009/inventory/getDetails/"+categoryId, CategoryDTO.class).getBody();
		
	}
		catch(HttpClientErrorException e){
			throw new InvalidCategoryId("CATEGORY ID OF ORDER ID IS NOT VALID");
		}}
	public ProductDTO findByProduct(int productId)throws InvalidProductId {
		// TODO Auto-generated method stub
		try {
		   return restTemplate.getForEntity("http://localhost:9000/inventory/getbyid/"+productId, ProductDTO.class).getBody();
		
	}
		catch(HttpClientErrorException e){
			throw new InvalidProductId("PRODUCT ID OF ORDER ID IS NOT VALID");
		}
	}
	
	public IngredientsDTO findByIngredient(int ingredientId) {
		return restTemplate.getForEntity("http://localhost:9999/inventory/getIngredient/"+ingredientId, IngredientsDTO.class).getBody();
	}



	@Override
	public Orders create(Orders order) {
		repo.save(order);
		return order;
	}

public boolean checkIngredients(int quantity,List<Integer>ingredients) {
	for(int i:ingredients) {
	if(findByIngredient(i).getQuantity()!=quantity) {
	restTemplate.put("http://localhost:9999/inventory/updateIngredient/"+i+"/"+quantity,IngredientsDTO.class);	
	return true;
	}
}
	return false;
}
	@Override
	public String statusOrder(int categoryId,int productId,int quantity,List<Integer>ingredients) throws InvalidCategoryId,InvalidProductId {
		// TODO Auto-generated method stub
		if(findByCategory(categoryId)!=null) {
			if(findByProduct(productId)!=null) {
				
				if(checkIngredients(quantity,ingredients))
				return "order accepted";
				
			}
		}
		
		return "order rejected";
	}

	@Override
	public Orders getById(int orderId)throws InvalidOrderId {
		// TODO Auto-generated method stub
		return repo.findById(orderId).orElseThrow(()-> new InvalidOrderId("InvalidOrderId exception"));
	}



}
