package sh.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Hibernate 3 Bootstrapping

public class HbUtil {
	private static final SessionFactory factory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		// create hib config object
		Configuration cfg = new Configuration();
		// read config from hibernate.cfg.xml
		cfg.configure();
		// build and return session factory
		return cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static void shutdown() {
		factory.close();
	}
}


