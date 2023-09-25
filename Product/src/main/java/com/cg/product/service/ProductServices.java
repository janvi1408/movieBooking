package com.cg.product.service;

import com.cg.product.exception.ProductInvalidId;
import com.cg.product.model.myProduct;

public interface ProductServices {
public myProduct add(myProduct products);
public String delete(int pid) throws ProductInvalidId;
public myProduct update(int pid,String productName)throws ProductInvalidId;
public myProduct getByid(int pid)throws ProductInvalidId;
}
