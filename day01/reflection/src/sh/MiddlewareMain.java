package sh;

import java.util.Date;

public class MiddlewareMain {
	public static void main(String[] args) {
		
		Class<?>[] paramTypes = {Integer.class, Integer.class};
		Object[] params = {12, 5};
		
		Object res = Middleware.callMethod(Arithmetic.class, "add", paramTypes, params);
		System.out.println("Result : " + res);
		
		res = Middleware.callMethod(Arithmetic.class, "multiply", paramTypes, params);
		System.out.println("Result : " + res);
		
		res = Middleware.callMethod(Date.class, "toString", null, null);
		System.out.println("Date Result : " + res);
	}
}
