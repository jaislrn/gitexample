package sh.main;

import sh.daos.CustomerDaoImpl;
import sh.entities.Customer;
import sh.util.HbUtil;

public class Hb5Main {
	public static void main(String[] args) {
		try {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			HbUtil.beginTransaction();
			
			Customer c = new Customer(0, "Virat", "4567");
			dao.addCustomer(c);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
	}
}
