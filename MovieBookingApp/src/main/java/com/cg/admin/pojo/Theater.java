package com.cg.admin.pojo;

import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Theater {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private  Integer tid;
private List<Integer>Movies;
private String theaterName;
private List<Integer>City;
}
