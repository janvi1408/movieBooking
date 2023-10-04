package com.cg.admin.service;

import java.util.List;

import com.cg.admin.exception.InvalidCategory;
import com.cg.admin.exception.InvalidId;
import com.cg.admin.pojo.Category;

public interface AdminService {
public Category add(Category category)throws InvalidCategory,InvalidId;
public Category getCategory(int categoryId)throws InvalidId;
}
