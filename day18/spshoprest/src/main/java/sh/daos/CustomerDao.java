package sh.daos;

import sh.entities.Customer;

public interface CustomerDao {

	Customer findCustomer(String email);

	void addCustomer(Customer cust);

}