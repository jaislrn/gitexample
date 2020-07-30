package demo01;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessingImpl implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("postProcessBeforeInitialization() called " + beanName);
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("postProcessAfterInitialization() called " + beanName);
		return bean;
	}
}
