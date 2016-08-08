package com.github.bia;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.WebDriverRunner;
import com.github.bia.sberbank.steps.ConverterWidgetSteps;

public class TestBase {
	
	protected WebDriver driver;
	
	protected ConverterWidgetSteps converterSteps;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver(new DesiredCapabilities()); // TODO Сделать, чтобы можно было указать в настройках
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		converterSteps = new ConverterWidgetSteps(driver);
		WebDriverRunner.setWebDriver(driver);
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
