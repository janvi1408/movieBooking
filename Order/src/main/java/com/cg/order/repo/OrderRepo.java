package com.cg.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.order.model.Orders;
@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {

}
