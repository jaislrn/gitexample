package sh;

import java.lang.reflect.Method;

public class Middleware {
	public static Object callMethod(Class<?> cls, String methodName, Class<?>[] paramTypes, Object[] params) {
		try {
			// create object of class at runtime
			Object obj = cls.newInstance();
			// find the method (with given param types) in the class
			Method m = cls.getDeclaredMethod(methodName, paramTypes);
			// invoke the method and collect result
			m.setAccessible(true);
			Object result = m.invoke(obj, params);
			// return result
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
