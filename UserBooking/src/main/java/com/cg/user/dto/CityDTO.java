package com.cg.user.dto;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class CityDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	private List<Integer> theaters;
	private String name;
}
