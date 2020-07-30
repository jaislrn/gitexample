package sh.main;

import java.util.Date;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.SessionStatistics;

import sh.entities.Customer;
import sh.util.HbUtil;

public class Hb1Main {
	
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		
		Transaction tx = null;
		try(Session session = factory.openSession()) {
			session.setHibernateFlushMode(FlushMode.AUTO);
			tx = session.beginTransaction();
			Customer c = new Customer(13, "C", "c", "222", "Pune", "d@gmail", new Date());
			System.out.println("calling save()");
			session.update(c);
			System.out.println("called save()");
//			System.out.println("calling flush()");
//			session.flush();
//			System.out.println("called flush()");
			System.out.println("calling commit()");
 			SessionStatistics stats = session.getStatistics();
 			System.out.println(stats);
			tx.commit();
			System.out.println("called commit()");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
				
		HbUtil.shutdown();
	}
	
}
