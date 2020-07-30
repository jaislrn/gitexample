package demo05;

import org.springframework.beans.factory.annotation.Autowired;

public class Prototype1 {
	@Autowired
	private Singleton1 field;
	public Prototype1() {
		System.out.println("Prototype1() called");
	}
	public Singleton1 getField() {
		return field;
	}
}
