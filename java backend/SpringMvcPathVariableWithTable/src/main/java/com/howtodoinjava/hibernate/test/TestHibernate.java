
package com.howtodoinjava.hibernate.test;

import org.hibernate.Session;
import com.howtodoinjava.hibernate.test.dto.*;
import com.howtodoinjava.hibernate.test.*; 

public class TestHibernate {
	
	public static void main(String[] args) {
		Session session = com.howtodoinjava.hibernate.test.HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
//		//Add new Employee object
//		EmployeeEntity emp = new EmployeeEntity();
//		emp.setEmail("demo-user@mail.com");
//		emp.setFirstName("demo");
//		emp.setLastName("user");
		
		//Student s= new Student();
		//s.setStudent_id("S201");
		//s.setStudent_name("zxcvbnm");
		//session.save(s);
		
		//session.getTransaction().commit();
		
		Student s= new Student();
		s.setId(1);
		
		session.load(s, Integer.class);
		System.out.println("Student Name="+s.getStudent_name());
		
		HibernateUtil.shutdown();
	}

}
