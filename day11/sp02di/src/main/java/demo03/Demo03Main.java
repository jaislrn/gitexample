package demo03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("demo03.xml");
	
//		PersonImpl p1 = (PersonImpl) ctx.getBean("p1");
//		System.out.println(p1);
	
		ctx.close();
	}
}


