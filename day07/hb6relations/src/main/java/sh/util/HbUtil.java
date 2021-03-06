package sh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HbUtil {
	private static final SessionFactory factory = buildSessionFactory();
	private static ServiceRegistry registry;
	private static SessionFactory buildSessionFactory() {
		// create service registry
		registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		// create metadata
		Metadata metadata = new MetadataSources(registry)
			.getMetadataBuilder()
			.build();
		// create session factory
		return metadata.getSessionFactoryBuilder().build();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session getCurrentSession() {
		return factory.getCurrentSession();
	}
	
	public static void beginTransaction() {
		getCurrentSession().getTransaction().begin();
	}
	
	public static void commitTransaction() {
		getCurrentSession().getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		getCurrentSession().getTransaction().rollback();
	}
	
	public static void shutdown() {
		factory.close();
		registry.close();
	}
}


