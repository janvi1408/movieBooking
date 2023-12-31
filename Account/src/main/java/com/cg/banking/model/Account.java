package com.cg.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int accountNo;
private String typeOfAccount;
private double balance;


}
