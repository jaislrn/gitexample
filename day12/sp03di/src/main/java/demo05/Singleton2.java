package demo05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

public class Singleton2 {
	private Prototype2 field;
	public Singleton2() {
		System.out.println("Singleton2() called");
	}
	@Lookup // internally calling ctx.getBean()
	public Prototype2 getField() {
		return field;
	}
}
