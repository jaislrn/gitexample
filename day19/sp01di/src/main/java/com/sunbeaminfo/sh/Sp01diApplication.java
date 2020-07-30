package com.sunbeaminfo.sh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.sunbeam.sh.GreetingBeanImpl;

@PropertySource("classpath:bank.properties")
@ComponentScan(basePackages = {"com.sunbeam.sh", "com.sunbeaminfo.sh"})
@SpringBootApplication
public class Sp01diApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(Sp01diApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring Boot!!");
		
//		System.out.println("Application Context : " + ctx.getClass().getName());
//		
//		GreetingBeanImpl bean = ctx.getBean(GreetingBeanImpl.class);
//		bean.greet("Sunbeam");
//	
//		Account acc = ctx.getBean(Account.class);
//		System.out.println(acc);
//		acc.withdraw(4000);
//		System.out.println(acc);
//		acc.withdraw(7000);
	}
}


