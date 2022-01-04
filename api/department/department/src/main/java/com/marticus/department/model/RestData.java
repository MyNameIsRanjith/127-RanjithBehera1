package com.marticus.department.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RestData {

	private String name;
	private String gender;
	private Float probability;
	private int count;
}