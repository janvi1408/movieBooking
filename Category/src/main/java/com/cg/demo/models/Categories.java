package com.cg.demo.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Categories {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer cid;
private int pid;
private String categoryName;


}
