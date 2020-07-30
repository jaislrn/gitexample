package sh.main;

import java.sql.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sh.daos.CustomerDaoImpl;
import sh.entities.Customer;

public class Sp04Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		CustomerDaoImpl dao = ctx.getBean(CustomerDaoImpl.class);
		List<Customer> list = dao.findAllCustomers();
		list.forEach(System.out::println);
		System.out.println();
		Customer newCust = new Customer(0, "Rahul", "rahul", "12345", "Pune", "rahuls@sunbeaminfo.com", null);
		int cnt = dao.addCustomer(newCust);
		System.out.println("Customers added: " + cnt);
//		System.out.println();
//		Customer cust = dao.findCustomerByEmail("rahul@sunbeaminfo.com");
//		System.out.println("Found: " + cust);
		ctx.close();
	}
}
