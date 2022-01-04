package com.marticus.customers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RestData {

//	private String name;
//	private String gender;
//	private Float probability;
//	private int count;
	
	private String activity;
	private String type;
	private int participants;
	private float price;
	private String link;
	private int key;
	private float accessibility;
}
