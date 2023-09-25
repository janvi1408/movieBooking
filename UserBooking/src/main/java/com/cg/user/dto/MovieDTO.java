package com.cg.user.dto;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class MovieDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private  Integer mid;
private String movieName;
private List<Integer>Theater;
}
