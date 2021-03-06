package sh.main;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sh.daos.BookDaoImpl;
import sh.entities.Book;
import sh.entities.SubjectwisePrice;
import sh.util.HbUtil;

public class Hb4Main {
	public static void main(String[] args) {
		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			Book b = dao.findById(22);
		//			System.out.println("Found: " + b);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<Book> list = dao.findAll();
		//			list.forEach(System.out::println);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}


		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<Book> list = dao.findByAuthor("KANETKAR");
		//			list.forEach(System.out::println);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			
		//			DetachedCriteria dcr = DetachedCriteria.forClass(Book.class);
		//			dcr.add(Restrictions.or(
		//					Restrictions.eq("subject", "OS"),
		//					Restrictions.eq("author", "SCHILDT")
		//				));
		//			List<Book> list = dao.findByCriteria(dcr);
		//			list.forEach(System.out::println);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<String> list = dao.getAuthors();
		//			System.out.println(list);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}
		//

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<Book> list = dao.findAllUsingHql();
		//			list.forEach(System.out::println);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}
		//
		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<Book> list = dao.findBySubject("JAVA");
		//			list.forEach(System.out::println);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<String> list = dao.getSubjects();
		//			System.out.println(list);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			Map<String, Double> result = dao.getSubjectwisePriceTotal();
		//			System.out.println(result);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<SubjectwisePrice> result = dao.getSubjectwisePriceTotalUsingResultTransformer();
		//			System.out.println(result);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			List<SubjectwisePrice> result = dao.getSubjectwisePriceTotalUsingCtor();
		//			System.out.println(result);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}

		//		try {
		//			BookDaoImpl dao = new BookDaoImpl();
		//			HbUtil.beginTransaction();
		//			int cnt = dao.deleteBySubject("Novell");
		//			System.out.println("Books deleted: " + cnt);
		//			HbUtil.commitTransaction();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			HbUtil.rollbackTransaction();
		//		}


//		try {
//			BookDaoImpl dao = new BookDaoImpl();
//			HbUtil.beginTransaction();
//			int cnt = dao.updatePriceByAuthor("KANETKAR");
//			System.out.println("Books updated: " + cnt);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
//		try {
//			BookDaoImpl dao = new BookDaoImpl();
//			HbUtil.beginTransaction();
//			List<Book> list = dao.getBooksOfPriceGT(500);
//			list.forEach(System.out::println);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

	
//		try {
//			BookDaoImpl dao = new BookDaoImpl();
//			HbUtil.beginTransaction();
//			List<Book> list = dao.getBooksInRange(100, 300);
//			list.forEach(System.out::println);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

//		try {
//			BookDaoImpl dao = new BookDaoImpl();
//			HbUtil.beginTransaction();
//			Double price = dao.getBookPrice(11);
//			System.out.println("Price: " + price);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

		try {
			BookDaoImpl dao = new BookDaoImpl();
			HbUtil.beginTransaction();
			Double price = dao.getBookPriceHib5(11);
			System.out.println("Price: " + price);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}

	}
	public static void main1(String[] args) {
		BookDaoImpl dao = new BookDaoImpl();
		HbUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
		Book b = dao.findById(11);
		System.out.println("Found: " + b);
		HbUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	}
}
