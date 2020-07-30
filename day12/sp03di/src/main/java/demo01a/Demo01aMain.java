package demo01a;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01aMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("demo01a.xml");
		AccountImpl a1 = (AccountImpl) ctx.getBean("a1");
		System.out.println(a1);
		PersonImpl p1 = (PersonImpl) ctx.getBean("p1");
		System.out.println(p1);
		System.out.println(a1.getAccHolder());
		System.out.println(p1.getAccount());
		ctx.close();
	}
}
