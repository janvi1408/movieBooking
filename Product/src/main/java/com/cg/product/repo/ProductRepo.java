package com.cg.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.product.model.myProduct;

@Repository
public interface ProductRepo extends JpaRepository<myProduct,Integer>{

}
