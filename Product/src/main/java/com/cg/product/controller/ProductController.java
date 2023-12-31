package com.cg.product.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.exception.ProductInvalidId;
import com.cg.product.model.myProduct;
import com.cg.product.repo.ProductRepo;
import com.cg.product.service.ProductServices;

@RestController
public class ProductController {

	@Autowired
	private ProductServices services;
	
	@PostMapping(value="/create" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<myProduct>add(@RequestBody myProduct product){
		return new ResponseEntity(services.add(product),HttpStatus.CREATED);
		
	}
	@GetMapping(value="/getbyid/{pid}")
	public ResponseEntity<myProduct>getByid(@PathVariable int pid)throws ProductInvalidId{
		return new ResponseEntity(services.getByid(pid),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value="/delete")
	public ResponseEntity<String> delete(@PathVariable int pid) throws ProductInvalidId{
	 return new ResponseEntity<String>(services.delete(pid),HttpStatus.ACCEPTED);
	
		
	}
}
