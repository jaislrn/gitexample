package demo03;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

public class EnvTestImpl {
	// to fetch environment variable of operating system
	@Autowired
	private Environment env;
	
	// to fetch local system and configuration
	@Value("#{systemProperties}")
	private Map<String, String> allProps;
	
	@Value("#{ systemProperties['java.version'] }")
	private String javaVersion;
	
	public String getProperty(String property) {
		return env.getProperty(property);
	}
	
	public String getJavaVersion() {
		return this.javaVersion;
	}

	public Map<String, String> getAllProps() {
		return allProps;
	}

}
