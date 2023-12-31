package com.cg.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.demo.exception.InvalidId;
import com.cg.demo.models.Categories;
import com.cg.demo.repo.Categorydao;

@Component
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private Categorydao category_dao;

	@Override
	public Categories add(Categories category) {
		category_dao.save(category);
		return category;
		
	}

	@Override
	public String delete(int categoryID) {
		// TODO Auto-generated method stub
		category_dao.deleteById(categoryID);
		return "SUCESSFULLY DELETED";
		
	}

	@Override
	public Categories getById(int cid) throws InvalidId {
		// TODO Auto-generated method stub
	Categories getDetails=category_dao.findById(cid).orElseThrow(()->new InvalidId("INVALID ID"));
	return getDetails;
	}

	@Override
	public Categories update(int cid,String name) throws InvalidId{
		// TODO Auto-generated method stub
		
		String names=getById(cid).getCategoryName();
		Categories newCategory=category_dao.findById(cid).get();
		getById(cid).setCategoryName(name);
		return newCategory;
		
	}



}
