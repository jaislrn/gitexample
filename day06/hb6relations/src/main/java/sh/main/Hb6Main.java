package sh.main;

import org.hibernate.Session;

import sh.entities.Dept;
import sh.entities.Emp;
import sh.util.HbUtil;

public class Hb6Main {
	public static void main(String[] args) {
//		try {
//			HbUtil.beginTransaction();
//			
//			Session session = HbUtil.getCurrentSession();
//			Dept d = session.get(Dept.class, 10);
//			System.out.println(d);
//			for (Emp e : d.getEmpList())
//				System.out.println(e);
//				
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

//		try {
//			HbUtil.beginTransaction();
//			
//			Session session = HbUtil.getCurrentSession();
//			
//			Dept d = new Dept(50, "MANAGEMENT", "PUNE");
//			d.getEmpList().add(new Emp(100, "Amit", "Trainer", 50));
//			d.getEmpList().add(new Emp(101, "Sandeep", "Trainer", 50));
//			d.getEmpList().add(new Emp(103, "Nilesh", "Trainer", 50));
//			
//			session.persist(d);
//			
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

//		try {
//			HbUtil.beginTransaction();
//			
//			Session session = HbUtil.getCurrentSession();
//			
//			Dept d = new Dept(60, "MANAGEMENT", "PUNE");
//			d.getEmpList().add(new Emp(100, "Amit", "Trainer", 50));
//			d.getEmpList().add(new Emp(101, "Sandeep", "Trainer", 50));
//			d.getEmpList().add(new Emp(103, "Nilesh", "Trainer", 50));
//			
//			session.merge(d);
//			
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

		try {
			HbUtil.beginTransaction();
			
			Session session = HbUtil.getCurrentSession();
			
			Dept d = session.get(Dept.class, 50);
			session.remove(d);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}

	}
}


