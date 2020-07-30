package demo06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo06Main {
	public static void main(String[] args) {
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("demo06.xml");
//		ctx.close();
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Demo06AppConfig.class);
		AccountImpl a1 = ctx.getBean(AccountImpl.class);
		System.out.println(a1);
		System.out.println(a1.getAccHolder());
		ctx.close();
	}
}


