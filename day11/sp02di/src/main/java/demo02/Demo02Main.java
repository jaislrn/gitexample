package demo02;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Demo02Main {
	public static void main(String[] args) {
		Resource res = new ClassPathResource("demo02.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res );
		
		PersonImpl p1 = (PersonImpl) factory.getBean("p1");
		System.out.println(p1);
		
		PersonImpl p0 = (PersonImpl) factory.getBean("p1");
		System.out.println(p0);
		
		PersonImpl p2 = (PersonImpl) factory.getBean("p2");
		System.out.println(p2);

		factory.destroySingletons();
	}
}


