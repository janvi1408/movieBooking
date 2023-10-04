package com.cg.user.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Advertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int aid;
	private int categoryId;
	@NotBlank(message="never be empty")
private String typeOfAdvertisement;
	@Size(min=3,message = "message should be bigger than 3")
	private String message;
}
