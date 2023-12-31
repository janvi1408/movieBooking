package com.cg.user.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int userId;
	@Size(min=3 , max=8 , message="size should be between 3 to 8")
private String userName;
}
