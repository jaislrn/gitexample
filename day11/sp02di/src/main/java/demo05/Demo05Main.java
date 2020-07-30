package demo05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo05Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo05.xml");
		
		Account a1 = (Account) ctx.getBean("a1");
		System.out.println("a1 : " + a1);
		a1.deposit(2000.00);
		System.out.println("a1 : " + a1);

		ctx.close();
	}
}	



