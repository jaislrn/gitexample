package sh.daos;

import org.hibernate.Session;

import sh.entities.Customer;
import sh.util.HbUtil;

public class CustomerDaoImpl {
	public void addCustomer(Customer c) {
		Session session = HbUtil.getCurrentSession();
		session.persist(c);
	}
}
