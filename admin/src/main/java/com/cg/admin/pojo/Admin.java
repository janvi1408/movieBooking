package com.cg.admin.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int adminId;
private String category;


}
