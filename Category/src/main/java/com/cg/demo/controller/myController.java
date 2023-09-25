package com.cg.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.exception.InvalidId;
import com.cg.demo.models.Categories;
import com.cg.demo.services.CategoryService;
import com.cg.demo.services.CategoryServiceImpl;


@RestController
public class myController {
	
	@Autowired
	private CategoryService serviceimp;
	
	
@PostMapping("/create")
public ResponseEntity<Categories> add(@RequestBody Categories category) {
return new ResponseEntity<Categories>(serviceimp.add(category),HttpStatus.CREATED);
	
}



@GetMapping("/update")
public ResponseEntity<Categories> update(@PathVariable int cid,@PathVariable String name) throws InvalidId{
return	new ResponseEntity<Categories>(serviceimp.update(cid, name),HttpStatus.OK);
	
}

@GetMapping("/delete")
public ResponseEntity<String> delete(@PathVariable int cid) {
	return new ResponseEntity<String>(serviceimp.delete(cid),HttpStatus.OK);
	
}
@GetMapping("/getDetails/{cid}")
public ResponseEntity<Categories> getDetail(@PathVariable int cid) throws InvalidId {
	return new ResponseEntity<Categories>(serviceimp.getById(cid),HttpStatus.ACCEPTED);
	
}
}
