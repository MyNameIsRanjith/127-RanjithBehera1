package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreTest {

	public static void main(String args[])
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		
		 Transaction t=session.beginTransaction();  
		 
		 	Account a1=new Account();  
		 	a1.setName("acn1");
		 	a1.setNumber("AC#0001");
		 	
		 	Savings_Account s1=new Savings_Account();  
		 	s1.setName("savacn1");
		 	s1.setNumber("SVAC#0001");
		 	s1.setInterest(489);
		 	
		 	Savings_Account s2=new Savings_Account();
		 	s2.setName("savacn2");
		 	//s2.setNumber("SVAC#0002");		 	
		 	s2.setInterest(666);
		 	
		 	Current_Account c1=new Current_Account();
		 	c1.setName("curacn1");
		 	c1.setNumber("CRAC#0001");
		 	c1.setDraft(12345678);
		 	
		 	Current_Account c2=new Current_Account(); 
		 	c2.setName("curacn2");
		 	//c2.setNumber("CRAC#0002");
		 	c2.setDraft(1000001);
		 	
		 	session.persist(a1);
		 	session.persist(s1);
		 	session.persist(s2);
		 	session.persist(c1);
		 	session.persist(c2);
		    t.commit();  
		    session.close();  
		    System.out.println("successfully inserted");  
		
	}
	      
//		    Employee e1=new Employee();  
//		    e1.setName("Gaurav Chawla");  
//		      
//		    Regular_Employee e2=new Regular_Employee();  
//		    e2.setName("Vivek Kumar");  
//		    e2.setSalary(50000);  
//		    e2.setBonus(5);  
//		      
//		    Contract_Employee e3=new Contract_Employee();  
//		    e3.setName("Arjun Kumar");  
//		    e3.setPay_per_hour(1000);  
//		    e3.setContract_duration("15 hours");  
//		      
//			session.persist(e1);  
//		    session.persist(e2);  
//		    session.persist(e3); 
//		 	t.commit();  
//		    session.close();  
//		    System.out.println("success");  
//		
//	}	
}