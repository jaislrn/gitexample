package sh.services;

import sh.entities.Customer;

public interface CustomerService {

	Customer findCustomer(String email);

	void addCustomer(Customer cust);

	Customer findCustomer(String email, String password);
}