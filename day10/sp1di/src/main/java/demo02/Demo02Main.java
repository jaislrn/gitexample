package demo02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo02.xml");
		
		AccountImpl a1 = (AccountImpl) ctx.getBean("a1");
		System.out.println("a1 : " + a1);
		a1.deposit(2000.00);
		System.out.println("a1 : " + a1);

		AccountImpl a2 = (AccountImpl) ctx.getBean("a2");
		System.out.println("a2 : " + a2);
		a2.withdraw(2000.00);
		System.out.println("a2 : " + a2);
		
		AccountImpl a3 = (AccountImpl) ctx.getBean("a3");
		System.out.println("a3 : " + a3);

		ctx.close();
	}
}	



