package com.cg.banking.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.exception.InvalidAccountId;
import com.cg.banking.exception.LessThanMinimum;
import com.cg.banking.model.Account;
import com.cg.banking.repo.AccountRepo;

@Component
public class AccountServiceImpl implements AccountService {
@Autowired
private AccountRepo repo;
	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		repo.save(account);
		return account;
	}

	@Override
	public String delete(int accountId)throws InvalidAccountId,LessThanMinimum {
		// TODO Auto-generated method stub
		Account acc=repo.findById(accountId).orElseThrow(()->new InvalidAccountId("this accountId is not valid"));
		repo.delete(acc);
		return "SUCCESSFULLY DELETED";
	}

	@Override
	public double deposit(int accountId, double amount)throws InvalidAccountId {
		// TODO Auto-generated method stub
		double newAmount=repo.findById(accountId).orElseThrow(()->new InvalidAccountId("this accountId is not valid")).getBalance()+amount;
		repo.findById(accountId).get().setBalance(newAmount);
		return newAmount;
	}

	@Override
	public double withdraw(int accountId, double amount)throws InvalidAccountId,LessThanMinimum {
		// TODO Auto-generated method stub
		double newAmount=repo.findById(accountId).orElseThrow(()->new InvalidAccountId("this accountId is not valid")).getBalance()-amount;
		if(newAmount<0) {
			throw new LessThanMinimum ("BALANCE LESS THAN AMOUNT");
		}
		repo.findById(accountId).get().setBalance(newAmount);
		return newAmount;
	}

}
