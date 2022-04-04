package com.epam.commonlib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderWriter {

	static Properties props = new Properties();;

	public static void addIntoProperties(String key, String value) throws IOException {

		// Populating the properties file
		props.put(key, value);

		// Instantiating the FileInputStream for output file
		String path = System.getProperty("user.dir") + ".\\src\\test\\resources\\configs.properties";
		FileOutputStream outputStrem = new FileOutputStream(path);
		// Storing the properties file
		props.store(outputStrem, "configs");
		System.out.println("Properties file created......");
	}

	public static synchronized String getProperty(String key) {

		try {
			FileReader file = new FileReader(".\\src\\test\\resources\\configs.properties");
			props = new Properties();
			props.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props.getProperty(key);
	}
}
