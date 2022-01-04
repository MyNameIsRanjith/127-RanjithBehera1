package com.marticus.customers.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.marticus.customers.dto.RestData;
import com.marticus.customers.dto.User;
import com.marticus.customers.entity.CustomersEntity;
import com.marticus.customers.service.CustomersService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/customers")
public class CustomersController {
	
	@Autowired
	CustomersService customersService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/")
	public ResponseEntity<Void> saveCustomer(@RequestBody CustomersEntity cust1)
	 {
		customersService.saveCustomer(cust1);
		return ResponseEntity.status(HttpStatus.CREATED).header("creation status", "created").build();
	 }
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomersEntity> getCustomersByID(@PathVariable long id)
	 {
		CustomersEntity cust2=customersService.findCustomersById(id);
	     return ResponseEntity.ok(cust2);
	 }
	
	@GetMapping("/")
	public ResponseEntity<List<CustomersEntity>> getCustomersList()
	 {
		List<CustomersEntity> cust3=customersService.findAllCustomers();
	     return ResponseEntity.ok(cust3);
	 }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomersById(@PathVariable long id)
	{
		String body="record succesfully deleted";
		
		Boolean deleteStatus=customersService.deleteCustomersById(id);
		if(!deleteStatus)
		{
			body="could not perform the delete operation";
		}
	     return ResponseEntity.ok().body(body);

	}
	
	@PutMapping("/")
	public ResponseEntity<String> updateCustomers(@RequestBody CustomersEntity custupdate)
	 {
		String updateStatus="updation successful";
		customersService.updateCustomers(custupdate);
	    return ResponseEntity.ok().body(updateStatus);
	 }
	
	@GetMapping("/fetch/{name}")
	public ResponseEntity<List<CustomersEntity>> getCustomersByName(@PathVariable String name)
	{
		List<CustomersEntity> cust4= customersService.findCustomersByName(name);
		return ResponseEntity.ok(cust4);
	}
	
	
	@GetMapping("/fetchp/{name}")
	public ResponseEntity<List<CustomersEntity>> getCustomersByNameLike(@PathVariable String name)
	{
		List<CustomersEntity> cust5= customersService.findCustomersByCustNameLike(name);
		return ResponseEntity.ok(cust5);
	}
	
	@GetMapping("/fetchp/{name}/{custid}")
	public ResponseEntity<List<CustomersEntity>> getCustomersByNameandNumber(@PathVariable String name,@PathVariable String custid)
	{
		List<CustomersEntity> cust6= customersService.findCustomersByCustNameAndCustId(name,custid);
		return ResponseEntity.ok(cust6);
	}
	
//	@GetMapping("/login/{username}/{password}")
//	public ResponseEntity<String> login(@PathVariable String username,
//			@PathVariable  String password)
//	{
//		String str1=getJWTToken();
//		return ResponseEntity.ok(str1);		
//	}
//	
	private String getJWTToken() {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
//				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
//	@GetMapping("/callfreeapi/{name}")
//	public ResponseEntity<RestData> getRestDatas()
//	{
//		RestData rstdata= new RestData();
//		String url="https://api.genderize.io/?name="+name;
//		//RestTemplate template=new RestTemplate();
//		rstdata=restTemplate.getForObject(url, RestData.class) ;
//		return ResponseEntity.ok(rstdata);		
//	}
	
	@GetMapping("/boredapi")
	public ResponseEntity<RestData> getRestDatas()
	{
		RestData rstdata= new RestData();
		String url="https://www.boredapi.com/api/activity";
		//RestTemplate template=new RestTemplate();
		rstdata=restTemplate.getForObject(url, RestData.class) ;
		return ResponseEntity.ok(rstdata);		
	}
}
