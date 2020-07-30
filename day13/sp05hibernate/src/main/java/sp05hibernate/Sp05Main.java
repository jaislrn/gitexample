package sp05hibernate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sh.daos.CustomerDao;
import sh.daos.CustomerDaoImpl;
import sh.entities.Customer;
import sh.services.CustomerServiceImpl;

public class Sp05Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		CustomerServiceImpl custService = ctx.getBean(CustomerServiceImpl.class);
		Customer cust = custService.getCustomer(2);
		System.out.println("Found : " + cust);
		ctx.close();
	}
}
