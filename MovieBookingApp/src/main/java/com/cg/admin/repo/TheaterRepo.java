package com.cg.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.admin.pojo.Theater;
@Repository
public interface TheaterRepo extends JpaRepository<Theater,Integer>{

}
