package com.cg.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler{ //annotation in Spring that allows you to define global exception handling for your Spring MVC controllers. It is typically used to centralize exception handling and error response generation for multiple controllers in your application{
@ExceptionHandler(ProductInvalidId.class)
public ResponseEntity<String> invalidProductId(ProductInvalidId e){
	return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}
}
