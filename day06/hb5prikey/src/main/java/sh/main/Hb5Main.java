package sh.main;

import org.hibernate.Session;

import sh.daos.CustomerDaoImpl;
import sh.entities.Customer;
import sh.entities.StdRoll;
import sh.entities.Student;
import sh.util.HbUtil;

public class Hb5Main {
	public static void main(String[] args) {
//		try {
//			CustomerDaoImpl dao = new CustomerDaoImpl();
//			HbUtil.beginTransaction();
//			
//			Customer c = new Customer(0, "Rahul", "1111");
//			dao.addCustomer(c);
//			
//			c = new Customer(0, "Mahendra", "1111");
//			dao.addCustomer(c);
//			
//			c = new Customer(0, "Ravi", "1111");
//			dao.addCustomer(c);
//			
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

	
		try {
			CustomerDaoImpl dao = new CustomerDaoImpl();
			HbUtil.beginTransaction();
			
			Session session = HbUtil.getCurrentSession();
			Student s = session.get(Student.class, new StdRoll(2, 1));
			System.out.println("Found: " + s);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}

	}
}
