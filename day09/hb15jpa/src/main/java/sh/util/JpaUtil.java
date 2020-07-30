package sh.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("sh");
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void shutdown() {
		factory.close();
	}
}
