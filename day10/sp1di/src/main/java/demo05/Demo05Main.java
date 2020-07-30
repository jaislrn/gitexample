package demo05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo05Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountImpl a1 = (AccountImpl) ctx.getBean("a1");
		System.out.println("a1 : " + a1);
		a1.deposit(2000.00);
		System.out.println("a1 : " + a1);

		AccountImpl a2 = (AccountImpl) ctx.getBean("a2");
		System.out.println("a2 : " + a2);
		a2.withdraw(2000.00);
		System.out.println("a2 : " + a2);
		
		ctx.close();
	}
}	



