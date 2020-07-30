package demo03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo03.xml");
		
		AccountImpl a1 = (AccountImpl) ctx.getBean("a1");
		System.out.println("a1 : " + a1);
		
		for (TransactionImpl tx : a1.getTransactions())
			System.out.println("a1 tx : " + tx);

		
		ctx.close();
	}
}	



