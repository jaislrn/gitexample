package demo02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("demo02.xml");
		AccountImpl a1 = (AccountImpl) ctx.getBean("a1");
		System.out.println(a1);
		PersonImpl p1 = (PersonImpl) ctx.getBean("p1");
		System.out.println(p1);
		System.out.println(a1.getAccHolder());
		AccInfoImpl i1 = (AccInfoImpl) ctx.getBean("i1");
		System.out.println(i1);
		ctx.close();
	}
}
