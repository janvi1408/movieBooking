package com.cg.admin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.admin.dao.CategoryDAO;
import com.cg.admin.exception.InvalidCategory;
import com.cg.admin.exception.InvalidId;
import com.cg.admin.pojo.Category;
@Component
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CategoryDAO adminRepo;
	@Override
	public Category add(Category category)throws InvalidCategory,InvalidId {
		return adminRepo.save(category);
	}

	@Override
	public Category getCategory(int categoryId)throws InvalidId {
		return adminRepo.findById(categoryId).orElseThrow(()->new InvalidId("INVALID ID"));
	}
	

}
