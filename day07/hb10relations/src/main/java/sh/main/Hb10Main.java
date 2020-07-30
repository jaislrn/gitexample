package sh.main;

import org.hibernate.Session;

import sh.entities.Address;
import sh.entities.Emp;
import sh.util.HbUtil;

public class Hb10Main {
	public static void main(String[] args) {
//		try {
//			HbUtil.beginTransaction();
//			
//			Session session = HbUtil.getCurrentSession();
//			Emp e = session.get(Emp.class, 7900);
//			System.out.println(e);
//			System.out.println(e.getAddr());
//			
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
//
		try {
			HbUtil.beginTransaction();
			
			Session session = HbUtil.getCurrentSession();
			
			Address a = session.get(Address.class, 7900);
			System.out.println(a);
			System.out.println(a.getEmp());
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}


	}
}


