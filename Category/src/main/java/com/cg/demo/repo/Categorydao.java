package com.cg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.models.Categories;

@Repository
public interface Categorydao extends JpaRepository<Categories,Integer> {

}
