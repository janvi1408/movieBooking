package com.cg.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
//private <Product> product;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int orderId;
private String customerName;
private int productId;
private int categoryId;

}
