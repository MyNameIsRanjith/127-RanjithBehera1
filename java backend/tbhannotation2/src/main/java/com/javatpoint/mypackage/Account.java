package com.javatpoint.mypackage;  
import javax.persistence.*;  
  
@Entity  
@Table(name = "mainaccount")  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="account")  
  
public class Account {  
@Id  
@GeneratedValue(strategy=GenerationType.AUTO)  
      
@Column(name = "id")  
private int id;  
  
@Column(name = "name")  
private String name;

@Column(name = "number")  
private String number;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}   

}  