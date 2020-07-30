package sh.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sh.entities.Book;
import sh.util.HbUtil;

public class BookDao {
	public List<String> findSubjects() {
		Session session = HbUtil.getCurrentSession();
		String hql = "select distinct subject from Book b";
		Query<String> q = session.createQuery(hql);
		return q.getResultList();
	}
	
	public List<Book> findBySubject(String subject) {
		Session session = HbUtil.getCurrentSession();
		String hql = "from Book b where b.subject=:p_subject";
		Query<Book> q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		return q.getResultList();
	}
	
	public Book findById(int id) {
		Session session = HbUtil.getCurrentSession();
		return session.load(Book.class, id);
	}
}
