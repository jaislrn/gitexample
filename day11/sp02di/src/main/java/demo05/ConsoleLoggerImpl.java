package demo05;

import java.util.Date;

public class ConsoleLoggerImpl implements Logger {
	@Override
	public void log(String message) {
		String logMessage = new Date() + " -- " + message;
		System.out.println(logMessage);
	}
}
