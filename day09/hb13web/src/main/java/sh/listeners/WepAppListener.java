package sh.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import sh.util.HbUtil;

public class WepAppListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HbUtil.buildSessionFactory();
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HbUtil.shutdown();
	}
}


