package sh;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionMain {
	public static void main(String[] args) {
		try {
			//String className = "sh.Arithmetic";
			//Class<?> c = Class.forName(className);
			
			Class<?> c = Arithmetic.class;
 			
			System.out.println("Name: " + c.getName());
			Class<?> scls = c.getSuperclass();
			if(scls!=null)
				System.out.println("Super Class: " + scls.getName());
			Class<?>[] intfs = c.getInterfaces();
			for (Class<?> intf : intfs)
				System.out.println("Interface: " + intf.getName());
			
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields)
				System.out.println("\t - " + field);
			
			Constructor<?>[] ctors = c.getDeclaredConstructors();
			for (Constructor<?> ctor : ctors)
				System.out.println("\t + " + ctor);
			
			Method[] methods = c.getDeclaredMethods();
			for (Method method : methods)
				System.out.println("\t + " + method);

			Annotation[] anns = c.getDeclaredAnnotations();
			for (Annotation ann : anns)
				System.out.println("\t + " + ann);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
