package demo05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public AccountImpl a1() {
		AccountImpl a = new AccountImpl();
		a.setId(101);
		a.setType("Saving");
		a.setBalance(10000.00);
		return a;
	}
	
	@Bean
	public AccountImpl a2() {
		AccountImpl a = new AccountImpl(102, "Saving", 20000.00);
		return a;
	}
}
