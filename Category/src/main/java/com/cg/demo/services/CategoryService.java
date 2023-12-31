package com.cg.demo.services;

import org.springframework.stereotype.Component;

import com.cg.demo.exception.InvalidId;
import com.cg.demo.models.Categories;


public interface CategoryService {
public Categories add(Categories category);
public String delete(int category);
public Categories getById(int cid)throws InvalidId;
public Categories update(int cid,String name)throws InvalidId;
}
