package com.marticus.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.marticus.employee.vo.ProjectVO;
import com.marticus.employee.vo.TechnologyVO;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		
		return new RestTemplate();
		
	}
}
