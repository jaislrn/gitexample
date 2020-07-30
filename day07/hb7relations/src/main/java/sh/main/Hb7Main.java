package sh.main;

import org.hibernate.Session;

import sh.entities.Emp;
import sh.util.HbUtil;

public class Hb7Main {
	public static void main(String[] args) {
		try {
			HbUtil.beginTransaction();
			
			Session session = HbUtil.getCurrentSession();
			Emp e = session.get(Emp.class, 7900);
			System.out.println(e);
			System.out.println(e.getDept());
			
			session.refresh(e);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
	}
}


