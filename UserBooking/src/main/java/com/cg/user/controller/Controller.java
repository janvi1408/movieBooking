package com.cg.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.user.exception.InvalidId;
import com.cg.user.pojo.User;
import com.cg.user.service.UserService;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/user")
public class Controller {
	
	@Autowired
	private UserService service;
	@PostMapping(value="/user" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		return new ResponseEntity<User>(service.create(user),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getTheaters/{cid}")
	public ResponseEntity<List<String>> getTheater(@PathVariable int cid)throws InvalidId{
		return new ResponseEntity<List<String>>(service.city(cid),HttpStatus.OK);
	}
	@GetMapping(value="/getMovies/{tid}")
	public ResponseEntity<List<String>> getMovies(@PathVariable int tid){
		return new ResponseEntity<List<String>>(service.theater(tid),HttpStatus.OK);
	}
	
	@GetMapping(value="/getUser/{uid}")
	public ResponseEntity<User> getUser(@PathVariable int uid){
		return new ResponseEntity<User>(service.getUser(uid),HttpStatus.OK);
	}
}
