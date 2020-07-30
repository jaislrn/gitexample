package sh.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Customer findCustomer(String email) {
		Session session = sf.getCurrentSession();
		Query<Customer> q = session.createQuery("from Customer c where c.email = :p_email");
		q.setParameter("p_email", email);
		return q.getSingleResult();
	}
	
	@Override
	public void addCustomer(Customer cust) {
		Session session = sf.getCurrentSession();
		session.persist(cust);
	}
}

