package sh.main;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sh.daos.CustomerDao;
import sh.entities.Customer;
import sh.util.HbUtil;

public class Hb1Main {
	public static void main1(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		CustomerDao dao = new CustomerDao();
		
 		Customer cust = dao.findCustomerById(20);
 		System.out.println("Found: " + cust);
 		
 		//Customer newCust = new Customer(7, "James Bond", "007", "9876543210", "London", "james@bond.com", new Date(2000, 1, 1));
		//dao.addCustomer(newCust);
 		
		HbUtil.shutdown();
	}
	
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		
//		Session session = factory.openSession();
//		
//		Customer cust = session.load(Customer.class, 20);
//		System.out.println("Object of : " + cust.getClass().getName());
//		System.out.println("Found " + cust);
//		
//		session.close();

//		Transaction tx =  null;
//		try(Session session = factory.openSession()) {
//			tx = session.beginTransaction();
//			Customer c = new Customer(9, "Abc", "abc", "12344", "pune", "abc1@gmail", new java.util.Date());
//			//int id = (Integer)session.save(c);
//			//System.out.println("Customer added : " + id);
//			session.persist(c);
//			System.out.println("record inserted");
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}

//		Transaction tx =  null;
//		try(Session session = factory.openSession()) {
//			tx = session.beginTransaction();
//			Customer c = session.get(Customer.class, 7);
//			c.setName("Mr. James Bond");
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}

		
//		Transaction tx =  null;
//		try(Session session = factory.openSession()) {
//			tx = session.beginTransaction();
//			Customer c = session.get(Customer.class, 7);
//			session.evict(c); // take obj out of hibernate session
//			c.setName("James");
//			session.update(c); // add obj into session and dirty=true.
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}
		
		
//		Customer c = new Customer(9, "Xyz", "xyz", "7237823", "Hell", "xyz@gmail", new java.util.Date());
//		Transaction tx =  null;
//		try(Session session = factory.openSession()) {
//			tx = session.beginTransaction();
//			session.saveOrUpdate(c); // add obj into session and dirty=true.
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}		

//		Customer c = new Customer(19, "PQR", "pqr", "7237823", "Hell", "pqr@gmail", new java.util.Date());
//		Transaction tx =  null;
//		try(Session session = factory.openSession()) {
//			tx = session.beginTransaction();
//			session.saveOrUpdate(c); 
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}				

//		Customer c = new Customer(20, "PQR", "pqr", "7237823", "Pune", "pqrs@gmail", new java.util.Date());
//		Transaction tx =  null;
//		try(Session session = factory.openSession()) {
//			tx = session.beginTransaction();
//			session.merge(c); // SELECT --> UPDATE or INSERT
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}				

//		Transaction tx =  null;
//		try(Session session = factory.openSession()) {
//			tx = session.beginTransaction();
//			Customer c = session.get(Customer.class, 19);
//			session.remove(c);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}

		Transaction tx =  null;
		try(Session session = factory.openSession()) {
			tx = session.beginTransaction();
//			Customer c = session.load(Customer.class, 9);
			Customer c = new Customer();
			c.setId(9);
			session.remove(c);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		
//		session = factory.openSession();
//		
//		Query<Customer> q = session.createQuery("from Customer");
//		List<Customer> list = q.getResultList();
//		list.forEach(System.out::println);
//		
//		session.close();
		
		HbUtil.shutdown();
	}
	
}
