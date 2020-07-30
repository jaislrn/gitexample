package com.sunbeaminfo.sh;

import java.util.Date;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ConsoleLoggerImpl implements Logger {
	@Override
	public void log(String message) {
		String logMessage = new Date() + " -- " + message;
		System.out.println(logMessage);
	}
}
