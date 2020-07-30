package sh.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sh.entities.Customer;
import sh.util.HbUtil;

public class CustomerDao {
	public Customer findCustomerById(int id) {
		Customer cust = null;
		try(Session session = HbUtil.getSessionFactory().openSession()) {
			cust = session.find(Customer.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}
	
	public List<Customer> findAll(int id) {
		try(Session session = HbUtil.getSessionFactory().openSession()) {
			Query<Customer> q = session.createQuery("from Customer");
			return q.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addCustomer(Customer c) {
		Transaction tx = null;
		try(Session session = HbUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}






