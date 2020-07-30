package demo05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo05Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("demo05.xml");
//		Prototype1 p1 = ctx.getBean(Prototype1.class);
//		Prototype1 p2 = ctx.getBean(Prototype1.class);
//		Prototype1 p3 = ctx.getBean(Prototype1.class);
//		System.out.println(p1.getField() == p2.getField());

		Singleton2 s1 = ctx.getBean(Singleton2.class);
		System.out.println(s1.getField());
		System.out.println(s1.getField());
		System.out.println(s1.getField());
		
		Singleton2 s1a = ctx.getBean(Singleton2.class);
		System.out.println(s1a.getField());
		
		ctx.close();
	}
}
