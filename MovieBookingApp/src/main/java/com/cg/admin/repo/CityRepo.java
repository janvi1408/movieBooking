package com.cg.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.admin.pojo.City;
@Repository
public interface CityRepo extends JpaRepository<City,Integer>{

}
