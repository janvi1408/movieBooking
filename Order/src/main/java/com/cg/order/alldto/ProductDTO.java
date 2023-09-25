package com.cg.order.alldto;

import java.util.List;

import lombok.Data;
@Data
public class ProductDTO {
	private int pid;
	private List<Integer>ingredients;
private String productName;
}
