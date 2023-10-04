package com.cg.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.user.pojo.Advertisement;

public interface UserDAO extends JpaRepository<Advertisement,Integer>{

}
