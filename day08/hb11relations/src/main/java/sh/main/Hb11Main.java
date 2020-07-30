package sh.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sh.entities.Dept;
import sh.entities.Emp;
import sh.util.HbUtil;

public class Hb11Main {
	public static void main(String[] args) {
//		try {
//			HbUtil.beginTransaction();			
//			Session session = HbUtil.getCurrentSession();
//			
//			String hql = "select e.name, d.name from Emp e INNER JOIN e.dept d";
//			Query<Object[]> q = session.createQuery(hql);
//			List<Object[]> list = q.getResultList();
//			list.forEach(x -> System.out.println(Arrays.toString(x)));
//			
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

		try {
			HbUtil.beginTransaction();			
			Session session = HbUtil.getCurrentSession();
			
			String hql = "select e.name, e.dept.name from Emp e";
			Query<Object[]> q = session.createQuery(hql);
			List<Object[]> list = q.getResultList();
			list.forEach(x -> System.out.println(Arrays.toString(x)));
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
	}
}


