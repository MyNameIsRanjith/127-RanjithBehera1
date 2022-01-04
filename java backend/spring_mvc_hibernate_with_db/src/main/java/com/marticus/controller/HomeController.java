package com.marticus.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marticus.model.User;
import com.marticus.utility.HibernateUtil;

import antlr.collections.List;

@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User u1, Model model) {
		System.out.println("User Page Requested");
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setUserAge(u1.getUserAge());
		u.setUserName(u1.getUserName());
		session.save(u);
		session.getTransaction().commit();
		session.close();
		
		model.addAttribute("userName", u1.getUserName());
		model.addAttribute("userAge", u1.getUserAge());
		return "user";
	}
	
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String User(Model model) {
		System.out.println("Userlist Page Requested");
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List User =(List)session.createQuery("From User").list();
		ArrayList <User> uList = new ArrayList <User>();
		for (Iterator iterator2 =((java.util.List) User).iterator(); iterator2.hasNext();){
            User u = (User) iterator2.next(); 
            uList.add(u);
            System.out.println("User: " + u.getUserName()); 
         }
		model.addAttribute("uList",uList);
		return "userlist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id, Model model)  throws Exception
	{
		System.out.println("Delete Page Requested");
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User u=new User();
		u.setId(id);
		session.load(u, new Integer(id));
		session.delete(u);
		
		session.getTransaction().commit();
		session.close();
	
		return "redirect:userlist";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String updateUser(@PathVariable("id") int id, Model model) throws Exception
    {
		System.out.println("Update Page Requested");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User u= new User();
		u.setId(id);		
		session.load(u, new Integer(u.getId()));
		model.addAttribute("id", u.getId());	
		model.addAttribute("userName", u.getUserName());	
		model.addAttribute("userAge", u.getUserAge());	
		
		session.getTransaction().commit();
		session.close();		
    	return "redirect:userlist";
    }
	
	
	@RequestMapping(value = "/getsearch", method = RequestMethod.POST)
	public String getUser(String id, Model model) {
		System.out.println("Search Page Requested");
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User u2=new User();
		u2.setId(Integer.parseInt(id));
		session.load(u2, new Integer(id));
		
		model.addAttribute("id", u2.getId());
		model.addAttribute("userName", u2.getUserName());
		model.addAttribute("userAge", u2.getUserAge());
	
		session.getTransaction().commit();
		session.close();
		return "getsearch";
}
                                                                                                                                                   
}
