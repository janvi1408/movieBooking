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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private  Integer mid;
private String movieName;
private List<Integer>Theater;
}
