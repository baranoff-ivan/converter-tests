package com.github.bia.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestsProperties {

	public static final TestsProperties INSTANCE = new TestsProperties();

	private final Properties properties;

	private TestsProperties() {
		properties = new Properties();
		try {
			String target = System.getProperty("target", "local");
			properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getMainPageUrl() {
		return properties.getProperty("main_page_url", "http://www.sberbank.ru/ru/person");
	}

	public String getHubUrl() {
		return properties.getProperty("selenium.hub.url", null);
	}

	/**
	 * DesiredCapabilities determined by property selenuim.driver.
	 * Simplified implementation for driver selection mechanism.
	 * @return DesiredCapabilities
	 */
	public Capabilities getDesiredCapabilities() {
		String driverName = properties.getProperty("selenuim.driver", "firefox");
		if (driverName.equals("firefox")) {
			return DesiredCapabilities.firefox();
		} else if (driverName.equals("chrome")) {
			return DesiredCapabilities.chrome();
		} else if (driverName.equals("ie")) {
			return DesiredCapabilities.internetExplorer();
		} else if (driverName.equals("phantom")) {
			return DesiredCapabilities.phantomjs();
		} else {
			throw new IllegalArgumentException("Unknown driver: " + driverName);
		}
	}

}
