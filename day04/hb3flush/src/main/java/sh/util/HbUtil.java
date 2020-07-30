package sh.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import sh.entities.Customer;

// Hibernate 4/5 Bootstrapping

public class HbUtil {
	private static final SessionFactory factory = buildSessionFactory();
	private static ServiceRegistry registry;
	private static SessionFactory buildSessionFactory() {
		// create service registry
		registry = new StandardServiceRegistryBuilder()
				//.applySetting("hibernate.connection.driver", "com.mysql.cj.jdbc.Driver")
				//.applySetting("hibernate.connection.username", "nilesh")
				.configure()
				.build();
		// create metadata
		Metadata metadata = new MetadataSources(registry)
			//.addResource("Customer.hbm.xml")
			//.addAnnotatedClass(Customer.class)
			//.addAnnotatedClass(Book.class)
			.getMetadataBuilder()
			.build();
		// create session factory
		return metadata.getSessionFactoryBuilder().build();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static void shutdown() {
		factory.close();
		registry.close();
	}
}


