package sh.main;

import org.hibernate.Session;

import sh.entities.Emp;
import sh.entities.Meeting;
import sh.util.HbUtil;

public class Hb9Main {
	public static void main(String[] args) {
//		try {
//			HbUtil.beginTransaction();
//			
//			Session session = HbUtil.getCurrentSession();
//			Emp e = session.get(Emp.class, 7934);
//			System.out.println(e);
//			
//			for (Meeting m : e.getMeetingList())
//				System.out.println(m);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

		try {
			HbUtil.beginTransaction();
			
			Session session = HbUtil.getCurrentSession();
			Meeting m = session.get(Meeting.class, 2);
			System.out.println(m);
			
			for (Emp e : m.getEmpList())
				System.out.println(e);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
	
	}
}


