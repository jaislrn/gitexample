package demo04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo04Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo04.xml");
		
		Account a1 = (Account) ctx.getBean("a1");
		System.out.println("a1 : " + a1);
		a1.deposit(2000.00);
		System.out.println("a1 : " + a1);

		ctx.close();
	}
}	



