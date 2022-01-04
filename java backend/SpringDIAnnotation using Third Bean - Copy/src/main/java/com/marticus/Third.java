package com.marticus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Third {
	@Autowired
	private Third third;

	public void sayHello()
	{
		
		System.out.println("Hello from Injected bean in third class!!!");
		
	}
	
}
