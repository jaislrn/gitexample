package demo01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01Main {
	public static void main(String[] args) {
		/*
		AccountImpl a1 = new AccountImpl();
		a1.setId(101);
		a1.setType("Saving");
		a1.setBalance(10000.00);
		System.out.println("a1 : " + a1);
		a1.deposit(2000.00);
		System.out.println("a1 : " + a1);
		*/
		
		/*
		AccountImpl a2 = new AccountImpl(102, "Saving", 20000.00);
		System.out.println("a2 : " + a2);
		a2.withdraw(2000.00);
		System.out.println("a2 : " + a2);
		*/
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo01.xml");
		
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



