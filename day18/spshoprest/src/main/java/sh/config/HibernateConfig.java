package sh.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
@Configuration
public class HibernateConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource devDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("dev.db.driver"));
		dataSource.setUrl(env.getRequiredProperty("dev.db.url"));
		dataSource.setUsername(env.getRequiredProperty("dev.db.user"));
		dataSource.setPassword(env.getRequiredProperty("dev.db.password"));
		return dataSource;
	}
	
	@Bean
	public DriverManagerDataSource prodDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("prod.db.driver"));
		dataSource.setUrl(env.getRequiredProperty("prod.db.url"));
		dataSource.setUsername(env.getRequiredProperty("prod.db.user"));
		dataSource.setPassword(env.getRequiredProperty("prod.db.password"));
		return dataSource;
	}

	@Autowired
	@Bean
	public LocalSessionFactoryBean mysqlSessionFactory(DataSourceConfig dataSourceConfig) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan("sh.entities");
		factoryBean.setDataSource(dataSourceConfig.getDataSource());
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		factoryBean.setHibernateProperties(props);
		return factoryBean;
	}
	
	@Autowired
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
