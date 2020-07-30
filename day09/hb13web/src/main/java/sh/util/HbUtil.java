package sh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HbUtil {
	private static SessionFactory factory;
	private static ServiceRegistry registry;
	
	public static void buildSessionFactory() {
		if(factory != null)
			return;
		// create service registry
		registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		// create metadata
		Metadata metadata = new MetadataSources(registry)
			.getMetadataBuilder()
			.build();
		// create session factory
		factory = metadata.getSessionFactoryBuilder().build();
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


