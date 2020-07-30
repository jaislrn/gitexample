package sh.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sh.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	public List<Customer> findByEmailAndPassword(String email, String password);
}
