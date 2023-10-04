package com.cg.admin.contoller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.admin.exception.InvalidCategory;
import com.cg.admin.exception.InvalidId;
import com.cg.admin.pojo.Category;
import com.cg.admin.service.AdminService;

import jakarta.validation.Valid;

public class AdminController {
	@Autowired AdminService services;

	private static final List<String> ALLOWED_CATEGORIES = Arrays.asList("house", "car", "electronic", "furniture");
	@PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) throws InvalidId, InvalidCategory{
		if (!ALLOWED_CATEGORIES.contains(category.getCategoryType())) {
	            throw new  InvalidCategory("Invalid Catgeory");
	        }
		return new ResponseEntity<Category>(services.add(category),HttpStatus.CREATED);
	}
	
	@GetMapping(value= "/category /{id}")
	public ResponseEntity<Category> get(@Valid @PathVariable int id) throws InvalidId{
		return new ResponseEntity<Category>(services.getCategory(id),HttpStatus.OK);
	}
}
