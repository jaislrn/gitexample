package sh.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sh.entities.Customer;

//@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addCustomer(Customer c) {
		em.persist(c);
	}
	
	@Override
	public Customer findCustomer(int id) {
		return em.find(Customer.class, id);		
	}
}
