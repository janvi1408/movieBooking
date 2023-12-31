package com.cg.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admin.exception.InvalidId;
import com.cg.admin.pojo.City;
import com.cg.admin.pojo.Movies;
import com.cg.admin.pojo.Theater;
import com.cg.admin.services.MovieService;


@RestController
//@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MovieService service;
	
@PostMapping(value="/city" , consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<City> addCity(@RequestBody City city){
	return new ResponseEntity<City>(service.addCity(city),HttpStatus.CREATED);
}

@DeleteMapping("/city/{cid}")
public ResponseEntity<String> removeCity(@PathVariable int cid)throws InvalidId{
	return new ResponseEntity<String>(service.removeCity(cid),HttpStatus.OK);
}

@GetMapping("/city/{cid}")
public ResponseEntity<City> getCity(@PathVariable int cid)throws InvalidId{
	return new ResponseEntity<City>(service.getCity(cid),HttpStatus.OK);
}

@PostMapping(value="/theater" , consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Theater> addTheater(@RequestBody Theater theater){
	return new ResponseEntity<Theater>(service.addTheater(theater),HttpStatus.CREATED);
}

@DeleteMapping("/theater/{tid}")
public ResponseEntity<String> removeTheater(@PathVariable int tid)throws InvalidId{
	return new ResponseEntity<String>(service.removeTheater(tid),HttpStatus.OK);
}
@GetMapping("/theater/{tid}")
public ResponseEntity<Theater> getTheater(@PathVariable int tid)throws InvalidId{
	return new ResponseEntity<Theater>(service.getTheater(tid),HttpStatus.OK);
}

@PostMapping(value="/movies", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Movies> addMovies(@RequestBody Movies movies){
	return new ResponseEntity<Movies>(service.addMovies(movies),HttpStatus.CREATED);
}

@DeleteMapping("/movies/{mid}")
public ResponseEntity<String> removeMovies(@PathVariable int mid)throws InvalidId{
	return new ResponseEntity<String>(service.removeMovies(mid),HttpStatus.OK);
}

@GetMapping("/movies/{mid}")
public ResponseEntity<Movies> getMovies(@PathVariable int mid)throws InvalidId{
	return new ResponseEntity<Movies>(service.getMovie(mid),HttpStatus.OK);
}

}
