package sh.daos;

import javax.persistence.EntityManager;

import sh.entities.Dept;
import sh.util.JpaUtil;

public class DeptDao {
	public Dept findById(int id) {
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManager();
			return em.find(Dept.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(em!=null)
				em.close();
		}
		return null;
	}
	
	public void addDept(Dept d) {
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(d);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			if(em!=null)
				em.close();
		}
	}
}
