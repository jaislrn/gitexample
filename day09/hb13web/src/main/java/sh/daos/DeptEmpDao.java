package sh.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sh.entities.Dept;
import sh.entities.Emp;
import sh.util.HbUtil;

public class DeptEmpDao {
	public List<Emp> findAllEmp() {
		String hql = "select e from Emp e join fetch e.dept";
		Session session = HbUtil.getCurrentSession();
		Query<Emp> q = session.createQuery(hql);
		return q.getResultList();
	}
	
	public List<Dept> findAllDept() {
		String hql = "from Dept d";
		Session session = HbUtil.getCurrentSession();
		Query<Dept> q = session.createQuery(hql);
		return q.getResultList();
	}
	
	public Dept findDeptById(int id) {
		Session session = HbUtil.getCurrentSession();
		return session.get(Dept.class, id);
	}
}

