package com.sunbeam.sh;

import java.util.List;

public class JdbcMain {
	public static void main(String[] args) {
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			List<Customer> list = dao.findAll();
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
