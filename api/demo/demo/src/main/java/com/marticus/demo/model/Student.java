package com.marticus.demo.model;

public class Student {
public String stuId;
public String stuName;

public String getStuId() {
	return stuId;
}
public void setStuId(String stuId) {
	this.stuId = stuId;
}
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}
public Student(String stuId, String stuName) {
	super();
	this.stuId = stuId;
	this.stuName = stuName;
}
}
