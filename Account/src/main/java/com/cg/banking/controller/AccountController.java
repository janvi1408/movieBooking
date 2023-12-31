package com.cg.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.banking.exception.InvalidAccountId;
import com.cg.banking.model.Account;
import com.cg.banking.services.AccountService;


@RestController
public class AccountController {
	@Autowired
	private AccountService service;
	
@PostMapping(value="/createAccount"  , consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account>create(@RequestBody Account account){
	return new ResponseEntity<Account>(service.create(account),HttpStatus.CREATED);
}

@PostMapping(value="/deleteAccount/{accountId}"  )
public ResponseEntity<String>delete(@PathVariable int accountId)throws InvalidAccountId,com.cg.banking.exception.LessThanMinimum {
	return new ResponseEntity<String>(service.delete(accountId),HttpStatus.OK);
}

@PostMapping(value="/deposit/{accountId}/{amount}" )
public ResponseEntity<Double>deposit(@PathVariable int accountId,@PathVariable double amount)throws InvalidAccountId{
	return new ResponseEntity<Double>(service.deposit(accountId,amount),HttpStatus.OK);
}

@PostMapping(value="/withdraw/{accountId}/{amount}" )
public ResponseEntity<Double>withdraw(@PathVariable int accountId,@PathVariable double amount)throws InvalidAccountId,com.cg.banking.exception.LessThanMinimum {
	return new ResponseEntity<Double>(service.withdraw(accountId,amount),HttpStatus.OK);
}
}
