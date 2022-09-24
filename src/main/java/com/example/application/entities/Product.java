package com.example.application.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name;
	private double Currentprice;
	private boolean promotion;
	private boolean selected; 
	private boolean avalaible;
	private String photoName;
	@ManyToOne
	private Category category;

}
