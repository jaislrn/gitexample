package sh.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ParameterMode;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;

import sh.entities.Book;
import sh.entities.SubjectwisePrice;
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

	public Map<String,Double> getSubjectwisePriceTotal() {
		Session session = HbUtil.getCurrentSession();
		String hql = "select b.subject, sum(b.price) from Book b group by b.subject";
		Query<Object[]> q = session.createQuery(hql);
		List<Object[]> list = q.getResultList();
		HashMap<String, Double> result = new HashMap<String, Double>();
		for (Object[] data : list)
			result.put((String)data[0], (Double)data[1]);
		return result;
	}
	
	public List<SubjectwisePrice> getSubjectwisePriceTotalUsingResultTransformer() {
		Session session = HbUtil.getCurrentSession();
		String hql = "select b.subject, sum(b.price) from Book b group by b.subject";
		Query<?> q = session.createQuery(hql);
		q.setResultTransformer(new ResultTransformer() {
			@Override
			public Object transformTuple(Object[] tuple, String[] aliases) {
				return new SubjectwisePrice((String)tuple[0], (Double)tuple[1]);
			}			
			@Override
			public List transformList(List collection) {
				return collection;
			}
		});
		return (List<SubjectwisePrice>) q.list();
	}
	
	public List<SubjectwisePrice> getSubjectwisePriceTotalUsingCtor() {
		Session session = HbUtil.getCurrentSession();
		String hql = "select new sh.entities.SubjectwisePrice(b.subject, sum(b.price)) from Book b group by b.subject";
		Query<SubjectwisePrice> q = session.createQuery(hql);
		return q.list();
	}
	
	public int deleteBySubject(String subject) {
		Session session = HbUtil.getCurrentSession();
		String hql = "delete from Book b where b.subject=:p_subject";
		Query q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		return q.executeUpdate();
	}
	
	public int updatePriceByAuthor(String author) {
		Session session = HbUtil.getCurrentSession();
		String hql = "update Book b set b.price=b.price+50 where b.author=:p_author";
		Query q = session.createQuery(hql);
		q.setParameter("p_author", author);
		return q.executeUpdate();
	}
	
	public List<Book> getBooksOfPriceGT(double price) {
		Session session = HbUtil.getCurrentSession();
		Query<Book> q = session.getNamedQuery("qryBooksOfPriceGT");
		q.setParameter("p_price", price);
		return q.getResultList();
	}
	
//	public List<Book> getBooksInRange(double minPrice, double maxPrice) {
//		Session session = HbUtil.getCurrentSession();
//		NativeQuery<Book> q = session.getNamedNativeQuery("spBooksInRange");
//		q.setParameter("p1", minPrice);
//		q.setParameter("p2", maxPrice);
//		return q.getResultList();
//	}
	
	public List<Book> getBooksInRange(double minPrice, double maxPrice) {
		Session session = HbUtil.getCurrentSession();
		NativeQuery<Book> q = session.createNativeQuery("CALL books_in_range(:p1,:p2)");
		q.setHint("org.hibernate.callable", "true");
		q.addEntity(Book.class);
		q.setParameter("p1", minPrice);
		q.setParameter("p2", maxPrice);
		return q.getResultList();
	}
	
	public Double getBookPrice(int id) {
		Session session = HbUtil.getCurrentSession();
		
		Double price = session.doReturningWork(new ReturningWork<Double>() {
			@Override
			public Double execute(Connection con) throws SQLException {
				try(CallableStatement stmt = con.prepareCall("CALL book_price(?,?)")) {
					stmt.setInt(1, id);
					stmt.registerOutParameter(2, Types.DOUBLE);
					stmt.execute();
					return stmt.getDouble(2);
				}
			}
		});
		
		return price;
	}

	public Double getBookPriceHib5(int id) {
		Session session = HbUtil.getCurrentSession();
		ProcedureCall sp = session.createStoredProcedureCall("book_price");
		sp.registerStoredProcedureParameter("id_val", Integer.class, ParameterMode.IN);
		sp.registerStoredProcedureParameter("price_val", Double.class, ParameterMode.OUT);
		sp.setParameter("id_val", id);
		sp.execute();
		return (Double)sp.getOutputParameterValue("price_val");
	}

}







