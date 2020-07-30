package sh.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sh.entities.Item;
import sh.util.HbUtil;

public class Hb12Main {
	public static void main(String[] args) {
		try {
		HbUtil.beginTransaction();			
		Session session = HbUtil.getCurrentSession();
		
		String hql = "from Item i";
		Query<Item> q = session.createQuery(hql);
		List<Item> list = q.getResultList();
		list.forEach(System.out::println);
		
		HbUtil.commitTransaction();
	} catch (Exception e) {
		e.printStackTrace();
		HbUtil.rollbackTransaction();
	}

	}
}
