package com.sunbeam.sh;

import java.io.InputStream;
import java.util.Properties;

public class JdbcUtil {
	public static final Properties props = new Properties();
	public static final String DB_URL;
	public static final String DB_DRIVER;
	public static final String DB_USER;
	public static final String DB_PASSWORD;
	
	static {
		try(InputStream in = JdbcUtil.class.getResourceAsStream("/jdbc.properties")) {
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DB_URL = props.getProperty("db.url", "");
		DB_DRIVER = props.getProperty("db.driver", "");
		DB_USER = props.getProperty("db.user", "");
		DB_PASSWORD = props.getProperty("db.password", "");
		
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

