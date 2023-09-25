package com.cg.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.pojo.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
