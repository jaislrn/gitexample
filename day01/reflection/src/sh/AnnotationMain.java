package sh;

import java.lang.annotation.Annotation;

public class AnnotationMain {
	public static void main(String[] args) {
		Annotation[] anns = Arithmetic.class.getAnnotations();
		for (Annotation ann : anns)
			System.out.println(ann);
	
		Readme r = Arithmetic.class.getDeclaredAnnotation(Readme.class);
		if(r!=null && r.author().equals("Nilesh")) {
			String value = r.value();
			if(value == null)
				value = "My Value";
			
			System.out.println("This class by Nilesh");
			System.out.println("Class Info: " + r.info());
		} else {
			System.out.println("This class not authored by Nilesh");
		}
	}
}
