package sh.main;

import org.hibernate.Session;

import sh.entities.Dept;
import sh.entities.Emp;
import sh.util.HbUtil;

public class Hb8Main {
	public static void main(String[] args) {
//		try {
//			HbUtil.beginTransaction();
//			
//			Session session = HbUtil.getCurrentSession();
//			Emp e = session.get(Emp.class, 7900);
//			System.out.println(e);
//			System.out.println(e.getDept());
//			for (Emp emp : e.getDept().getEmpList())
//				System.out.println(emp);
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
//			Dept d = new Dept(0, "TRAINING", "PUNE");
//			Emp e1 = new Emp(0, "Amit", "Trainer");
//			Emp e2 = new Emp(0, "Sandeep", "Trainer");
//			Emp e3 = new Emp(0, "Nilesh", "Trainer");
//			d.addEmp(e1);
//			d.addEmp(e2);
//			d.addEmp(e3);
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
//			Emp e = new Emp(0, "Nitin", "CEO");
//			Dept d = new Dept(0, "Management", "Pune");
//			d.addEmp(e);
//
//			session.persist(e);
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
			
			Dept d = session.get(Dept.class, 51);
			session.remove(d);
			
			Emp e = session.get(Emp.class, 105);
			session.remove(e);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}


	}
}


