package com.cg.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.user.dao.UserRepo;
import com.cg.user.dto.CityDTO;
import com.cg.user.dto.MovieDTO;
import com.cg.user.dto.TheaterDTO;
import com.cg.user.exception.InvalidId;
import com.cg.user.pojo.User;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	@Autowired  RestTemplate rest;


@Override

public List<String> city(int cid) throws InvalidId {
	// TODO Auto-generated method stub
List<Integer> th =rest.getForEntity("http://localhost:2222/city/"+ cid,CityDTO.class).getBody().getTheaters();
List<String> thname = new ArrayList<String>();

for(Integer i:th) {
	try {
	TheaterDTO theater = rest.getForEntity("http://localhost:2222/theater/" + i, TheaterDTO.class).getBody();
	thname.add(theater.getTheaterName());}
	catch(HttpClientErrorException e) {
		throw new InvalidId("exception of user");
	}
}
return thname;

}

@Override
public List<String> theater(int tid) {
	List<Integer>m=rest.getForEntity("http://localhost:2222/theater/" + tid,TheaterDTO.class).getBody().getMovies();
	List<String>movies=new ArrayList<String>();
	for(Integer i:m) {
		MovieDTO movie=rest.getForEntity("http://localhost:2222/movies/" + i,MovieDTO.class).getBody();
		movies.add(movie.getMovieName());
	}
	
	return movies;
}

@Override
public User create(User user) {
	// TODO Auto-generated method stub
	return repo.save(user);
	
}

@Override
public User getUser(int uid) {
return repo.findById(uid).get();
}

}
