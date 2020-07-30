package sh.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import sh.entities.Book;
import sh.util.HbUtil;

public class BookDaoImpl {
	public Book findById(int id) {
		Session session = HbUtil.getCurrentSession();
		return session.find(Book.class, id);
	}
	public List<Book> findAllUsingCriteria() {
		Session session = HbUtil.getCurrentSession();
		Criteria cr = session.createCriteria(Book.class);
		cr.addOrder(Order.asc("subject"));
		cr.addOrder(Order.desc("price"));
		return cr.list();
	}
	public List<Book> findByAuthor(String author) {
		Session session = HbUtil.getCurrentSession();
		Criteria cr = session.createCriteria(Book.class);
		cr.add(Restrictions.eq("author", author));
		return cr.list();
	}
	public List<Book> findByCriteria(DetachedCriteria dcr) {
		Session session = HbUtil.getCurrentSession();
		Criteria cr = dcr.getExecutableCriteria(session);
		return cr.list();
	}
	public List<String> getAuthors() {
		Session session = HbUtil.getCurrentSession();
		String sql = "SELECT DISTINCT(AUTHOR) FROM books";
		NativeQuery<String> q = session.createNativeQuery(sql);
		return q.getResultList();
	}
	
	public List<Book> findAllUsingHql() {
		Session session = HbUtil.getCurrentSession();
		String hql = "from " + Book.class.getName() + " b order by b.name";
		Query<Book> q = session.createQuery(hql);
		return q.getResultList();
	}
//	public List<Book> findBySubject(String subject) {
//		Session session = HbUtil.getCurrentSession();
//		String hql = String.format("from %s b where b.subject=?1", Book.class.getName());
//		Query<Book> q = session.createQuery(hql);
//		q.setParameter(1, subject);
//		return q.getResultList();
//	}

	public List<Book> findBySubject(String subject) {
		Session session = HbUtil.getCurrentSession();
		String hql = String.format("from %s b where b.subject=:p_subject", Book.class.getName());
		Query<Book> q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		return q.getResultList();
	}
	
	public List<String> getSubjects() {
		Session session = HbUtil.getCurrentSession();
		String hql = "select distinct b.subject from Book b";
		Query<String> q = session.createQuery(hql);
		return q.getResultList();
	}

}
