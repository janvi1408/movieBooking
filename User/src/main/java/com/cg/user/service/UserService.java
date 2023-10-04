package com.cg.user.service;


import java.util.List;

import com.cg.user.exception.InvalidId;
import com.cg.user.pojo.Advertisement;

public interface UserService {
public Advertisement add(Advertisement ad)throws InvalidId;
public Advertisement update(int aid,String newType)throws InvalidId;
public String delete(int aid)throws InvalidId;
public List<Advertisement> getAds(int categoryId);
public List<Advertisement> getAllAdvertise();
}
