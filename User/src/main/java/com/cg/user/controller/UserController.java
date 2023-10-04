package com.cg.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.user.exception.InvalidId;
import com.cg.user.pojo.Advertisement;
import com.cg.user.service.UserService;

import jakarta.validation.Valid;

public class UserController {

@Autowired
UserService service;
	
	@PostMapping(value= "/ads")
	public ResponseEntity<Advertisement> add(@Valid @RequestBody Advertisement ad) throws InvalidId{
		return new ResponseEntity<Advertisement>(service.add(ad),HttpStatus.CREATED);
	}
	
	@GetMapping(value= "/ads/{cid}")
	public ResponseEntity<List<Advertisement>> get(@Valid @PathVariable int cid) throws InvalidId{
		return new ResponseEntity<List<Advertisement>>(service.getAds(cid),HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/ads/{aid}")
	public ResponseEntity<String> delete(@Valid @PathVariable int aid) throws InvalidId{
		return new ResponseEntity<String>(service.delete(aid),HttpStatus.OK);
	}
	@PutMapping(value= "/ads/{aid}")
	public ResponseEntity<Advertisement> update(@Valid @PathVariable int aid,@PathVariable String message) throws InvalidId{
		return new ResponseEntity<Advertisement>(service.update(aid, message),HttpStatus.OK);
	}
}
