package demo03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Demo03Config.class);
		AccountImpl a1 = (AccountImpl) ctx.getBean("a1");
		System.out.println(a1);
		PersonImpl p1 = (PersonImpl) ctx.getBean("p1");
		System.out.println(p1);
		System.out.println(a1.getAccHolder());
		AccInfoImpl i1 = (AccInfoImpl) ctx.getBean("i1");
		System.out.println(i1);
		EnvTestImpl eb = ctx.getBean(EnvTestImpl.class);
		System.out.println("All system properties: " + eb.getAllProps());
		System.out.println("Java version: " + eb.getJavaVersion());
		System.out.println("UserName: " + eb.getProperty("USERNAME"));
		System.out.println("Path: " + eb.getProperty("PATH"));
		ctx.close();
	}
}
