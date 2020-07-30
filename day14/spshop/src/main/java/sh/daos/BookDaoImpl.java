package sh.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.entities.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public void addBook(Book b) {
		Session session = sf.getCurrentSession();
		session.persist(b);
	}
	
	@Override
	public void updateBook(Book b) {
		Session session = sf.getCurrentSession();
		session.merge(b);
	}
	
	@Override
	public void delBook(Book b) {
		Session session = sf.getCurrentSession();
		session.remove(b);
	}
	
	@Override
	public Book findBook(int id) {
		Session session = sf.getCurrentSession();
		return session.find(Book.class, id);
	}

	@Override
	public List<String> findSubjects() {
		Session session = sf.getCurrentSession();
		String hql = "select distinct b.subject from Book b";
		Query<String> q = session.createQuery(hql);
		return q.getResultList();
	}

	@Override
	public List<Book> findBooksBySubject(String subject) {
		Session session = sf.getCurrentSession();
		String hql = "from Book b where b.subject = :p_subject";
		Query<Book> q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		return q.getResultList();
	}
	
}

