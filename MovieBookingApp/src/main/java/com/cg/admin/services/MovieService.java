package com.cg.admin.services;

import com.cg.admin.exception.InvalidId;
import com.cg.admin.pojo.City;
import com.cg.admin.pojo.Movies;
import com.cg.admin.pojo.Theater;

public interface MovieService {
public City addCity(City city);
public String removeCity(int cid)throws InvalidId;
public City getCity(int cid)throws InvalidId;
public Theater addTheater(Theater theater);
public String removeTheater(int tid)throws InvalidId;
public Theater getTheater(int tid)throws InvalidId;
public Movies addMovies(Movies movies);
public String removeMovies(int mid)throws InvalidId;
public Movies getMovie(int mid)throws InvalidId;

}
