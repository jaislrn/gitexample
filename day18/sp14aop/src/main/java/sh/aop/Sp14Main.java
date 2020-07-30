package sh.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Sp14Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Account acc = ctx.getBean(Account.class);
		System.out.println("Bean : " + acc.getClass().getName());
		System.out.println();
		
		System.out.println(acc);
		acc.withdraw(3000);
		System.out.println(acc);
		System.out.println();
		
		acc.setAccId(102);
		acc.setType("Current");
		System.out.println(acc);
		acc.deposit(5000);
		System.out.println(acc);
		acc.withdraw(30000);
		System.out.println(acc);
		
		ctx.close();
	}
}


