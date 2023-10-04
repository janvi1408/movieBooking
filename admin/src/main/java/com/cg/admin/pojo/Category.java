package com.cg.admin.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Valid
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	 @Size(min=3, max=10, message = "Username cannot be empty")
private String categoryType;

}
