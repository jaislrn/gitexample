package demo03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:demo02.properties")
@Configuration
public class Demo03Config {
	@Bean
	public Object p1() {
		return new PersonImpl();
	}
	@Bean
	public Object a1() {
		return new AccountImpl();
	}
	@Bean
	public Object i1() {
		return new AccInfoImpl();
	}
	@Bean
	public Object e1() {
		return new EnvTestImpl();
	}
}


