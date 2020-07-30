package sh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sh.daos.CustomerDao;
import sh.entities.Customer;

@CrossOrigin
@RestController
public class CustomerControllerImpl {
	@Autowired
	private CustomerDao custDao;
	
	@PostMapping("/rest/customers/auth")
	public ResponseEntity<Customer> authenticate(@RequestBody Customer cust) {
		List<Customer> result = custDao.findByEmailAndPassword(cust.getEmail(), cust.getPassword());
		return new ResponseEntity<>(result.isEmpty()? null: result.get(0), HttpStatus.OK);
	}
	
	@GetMapping("/rest/customers")
	public ResponseEntity<List<Customer>> findAllCustomers() {
		List<Customer> result = custDao.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
