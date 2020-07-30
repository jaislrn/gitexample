package sh.daos;

import sh.entities.Customer;

public interface CustomerDao {

	void addCustomer(Customer c);

	Customer findCustomer(int id);

}