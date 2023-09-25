package com.cg.product.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class myProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private List<Integer>ingredients;
	private String productName;

}
