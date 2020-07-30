package sh.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sh.daos.CustomerDao;
import sh.entities.Customer;

@Service
public class CustomerServiceImpl {
	@Autowired
	private CustomerDao dao;

	@Transactional
	public void addCustomer(Customer c) {
		dao.addCustomer(c);
	}
	
	@Transactional
	public Customer findCustomer(int id) {
		return dao.findCustomer(id);
	}
}
