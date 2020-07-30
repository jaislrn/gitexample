package sh.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDataSourceConfigImpl implements DataSourceConfig {
	@Autowired
	@Qualifier("devDataSource")
	private DataSource dataSource;
	
	@Override
	public DataSource getDataSource() {
		return dataSource;
	}
}
