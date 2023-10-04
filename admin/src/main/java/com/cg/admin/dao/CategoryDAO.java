package com.cg.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.admin.pojo.Admin;
import com.cg.admin.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
