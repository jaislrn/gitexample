package sh.main;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import sh.daos.CustomerDao;
import sh.entities.Customer;
import sh.util.HbUtil;

public class Hb1Main {
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		CustomerDao dao = new CustomerDao();
		
 		Customer cust = dao.findCustomerById(3);
 		System.out.println("Found: " + cust);
 		
 		Customer newCust = new Customer(7, "James Bond", "007", "9876543210", "London", "james@bond.com", new Date(2000, 1, 1));
		dao.addCustomer(newCust);
 		
		HbUtil.shutdown();
	}
	
	public static void badMain(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		
		Session session = factory.openSession();
		
		Customer cust = session.get(Customer.class, 2);
		if(cust == null)
			System.out.println("Customer not found.");
		else
			System.out.println("Found " + cust);
		
		session.close();
		
		session = factory.openSession();
		
		Query<Customer> q = session.createQuery("from Customer");
		List<Customer> list = q.getResultList();
		list.forEach(System.out::println);
		
		session.close();
		
		HbUtil.shutdown();
	}
	
}
