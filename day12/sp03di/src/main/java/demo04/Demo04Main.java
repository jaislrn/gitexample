package demo04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo04Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("demo04.xml");
		PersonImpl p1a = (PersonImpl) ctx.getBean("p1");
		p1a.setEmail("ghule.nilesh@gmail.com");
		System.out.println(p1a);
		PersonImpl p1b = (PersonImpl) ctx.getBean("p1");
		System.out.println(p1b);
		PersonImpl p1c = (PersonImpl) ctx.getBean("p1");
		System.out.println(p1c);
		ctx.close();
	}
}
