package com.cg.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.product.exception.ProductInvalidId;
import com.cg.product.model.myProduct;
import com.cg.product.repo.ProductRepo;
@Component
public class ProductServicesImpl implements ProductServices{
	@Autowired
	private ProductRepo repo;

	@Override
	public myProduct add(myProduct products) {
		// TODO Auto-generated method stub
		return repo.save(products);
		
	}

	@Override
	public String delete(int pid) throws ProductInvalidId{
		// TODO Auto-generated method stub
		repo.findById(pid).orElseThrow(()-> new ProductInvalidId("this id doesnot exists"));
		repo.deleteById(pid);
		return "deleted successfully";

		
	}

	@Override
	public myProduct update(int pid, String productName) throws ProductInvalidId {
		// TODO Auto-generated method stub
		myProduct myProducts = repo.findById(pid).orElseThrow(()-> new ProductInvalidId("this id doesnot exists"));
		myProducts.setProductName(productName);
		return repo.save(myProducts);
		
	}

	@Override
	public myProduct getByid(int pid)throws ProductInvalidId {
		// TODO Auto-generated method stub
		myProduct myProducts = repo.findById(pid).orElseThrow(()-> new ProductInvalidId("this id doesnot exists"));
		
		
		return myProducts;
	}

}
