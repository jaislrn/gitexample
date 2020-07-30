package demo01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("demo01.xml");
		ctx.registerShutdownHook();
		
		AccountImpl a1 = (AccountImpl) ctx.getBean("a1");
		System.out.println("a1 : " + a1);
		a1.deposit(2000.00);
		System.out.println("a1 : " + a1);

		//ctx.close();
	}
}
