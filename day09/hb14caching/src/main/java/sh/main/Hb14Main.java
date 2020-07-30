package sh.main;

import org.hibernate.Session;

import sh.entities.Dept;
import sh.util.HbUtil;

public class Hb14Main {
	public static void main(String[] args) {
		try(Session session = HbUtil.openSession()) {
			Dept d1 = session.get(Dept.class, 10); // fire SELECT query on db & fetch record
			System.out.println(d1);
			Dept d2 = session.get(Dept.class, 10); // fire again ??
			System.out.println(d2);
			System.out.println("d1 same as d2 : " + (d1 == d2));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Session session = HbUtil.openSession()) {
			Dept d3 = session.get(Dept.class, 10); // fire SELECT query on db & fetch record
			System.out.println(d3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
