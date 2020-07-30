package sh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.daos.CustomerDao;
import sh.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custDao;
	
	@Override
	@Transactional
	public Customer findCustomer(String email) {
		return custDao.findCustomer(email);
	}
	
	@Override
	@Transactional
	public Customer findCustomer(String email, String password) {
		Customer cust = custDao.findCustomer(email);
		if(cust != null && cust.getPassword().equals(password))
			return cust;
		return null;
	}
	
	@Override
	@Transactional
	public void addCustomer(Customer cust) {
		custDao.addCustomer(cust);
	}
}

