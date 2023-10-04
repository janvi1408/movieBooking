package com.cg.user.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
@ControllerAdvice
public class ExceptionHandler {
	public ResponseEntity<CustomException> handleidNotFoundException(InvalidId except){
	 	CustomException custom = new CustomException();
	 	custom.setUserMessage(except.getMessage());
	 	custom.setDeveloperMessage(except.getLocalizedMessage());
	 	custom.setStatusCode(404);
        return new ResponseEntity<CustomException>(custom, HttpStatus.NOT_FOUND);

    }

// @org.springframework.web.bind.annotation.ExceptionHandler(InvalidAdvertisemnet.class)
//    public ResponseEntity<CustomException> handleInvalidCategoryException(InvalidAdvertisemnet except){
//	 	CustomException custom = new CustomException();
//	 	custom.setUserMessage(except.getMessage());
//	 	custom.setDeveloperMessage(except.getLocalizedMessage());
//	 	custom.setStatusCode(404);
//        return new ResponseEntity<CustomException>(custom, HttpStatus.NOT_FOUND);
//
//    }

 @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
    	 Map<String, String> resp = new HashMap<> () ;
    	 ex.getBindingResult().getAllErrors().forEach((error) ->{
    		 System.out.println(error.toString());
	    	 String fieldName = ((FieldError) error).getField();
	    	 String message = error.getDefaultMessage () ;
	    	 resp.put (fieldName, message);

    	 });
    	 return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);}
}
