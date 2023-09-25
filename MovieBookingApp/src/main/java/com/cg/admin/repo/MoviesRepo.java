package com.cg.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.admin.pojo.City;
import com.cg.admin.pojo.Movies;
@Repository
public interface MoviesRepo extends JpaRepository<Movies,Integer>{

}
