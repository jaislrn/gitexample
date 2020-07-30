package sh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hb2Main {
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		
		Session session = factory.openSession();
		
		Book b = session.get(Book.class, 31);
		System.out.println("Found " + b);
		
		session.close();
		
		factory.close();
	}
}
