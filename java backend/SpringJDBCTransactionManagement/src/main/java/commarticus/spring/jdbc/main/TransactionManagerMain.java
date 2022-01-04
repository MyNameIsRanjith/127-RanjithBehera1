package commarticus.spring.jdbc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marticus.spring.jdbc.model.Address;
import com.marticus.spring.jdbc.model.Customer;
import com.marticus.spring.jdbc.service.CustomerManager;
import com.marticus.spring.jdbc.service.CustomerManagerImpl;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		CustomerManager customerManager = ctx.getBean("customerManager",
				CustomerManagerImpl.class);

		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(3);
		customer.setName("Jayanta");
		Address address = new Address();
		address.setId(3);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Marine Drive ");
		customer.setAddress(address);
		return customer;
	}

}
