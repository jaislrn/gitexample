package sh.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sh.entities.Customer;

//@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer c) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(c);
	}
	
	@Override
	public Customer findCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Customer.class, id);		
	}
}
