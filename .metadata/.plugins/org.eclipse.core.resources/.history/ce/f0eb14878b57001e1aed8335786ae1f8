package com.cg.banking.services;

import com.cg.banking.exception.InvalidAccountId;
import com.cg.banking.exception.LessThanMinimum;
import com.cg.banking.model.Account;

public interface AccountService {
public Account create(Account accountId);
public String delete(int accountId)throws InvalidAccountId,LessThanMinimum ;
public double deposit(int accountId,double amount)throws InvalidAccountId ;
public double withdraw(int accountId,double amount)throws InvalidAccountId,LessThanMinimum ;
}
