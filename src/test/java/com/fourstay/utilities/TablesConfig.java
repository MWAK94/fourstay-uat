package com.fourstay.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class TablesConfig {

	private static Properties config;

static {
	String path = "./src/test/resources/test_data/datatables.properties";
	try {
		FileInputStream input = new FileInputStream(path);
		config = new Properties();
		config.load(input);
		input.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static String getProperty(String Key) {
	return config.getProperty(Key);
}
}
