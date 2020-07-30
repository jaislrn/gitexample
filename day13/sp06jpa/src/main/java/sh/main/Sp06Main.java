package sh.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sh.daos.CustomerDao;
import sh.daos.CustomerDaoImpl;
import sh.entities.Customer;
import sh.services.CustomerServiceImpl;

public class Sp06Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		CustomerServiceImpl custService = ctx.getBean(CustomerServiceImpl.class);
		Customer cust = custService.findCustomer(2);
		System.out.println("Found : " + cust);
		ctx.close();
	}
}
