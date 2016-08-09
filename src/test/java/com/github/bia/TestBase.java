package com.github.bia;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.WebDriverRunner;
import com.github.bia.steps.ConverterWidgetSteps;
import com.github.bia.util.TestsProperties;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.yandex.qatools.allure.annotations.Attachment;

public class TestBase {
	
	protected static WebDriver driver;
	
	protected static ConverterWidgetSteps converterSteps;
	
	@Rule
	public TestWatcher screenshotOnFailure = new TestWatcher() {
	    @Override
	    protected void failed(Throwable e, Description description) {
	        makeScreenshotOnFailure();
	    }

	    @Attachment("Скриншот при падении")
	    public byte[] makeScreenshotOnFailure() {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
	};
	
	@BeforeClass
	public static void setUp() throws Exception {
		WebDriverFactory.setDefaultHub(TestsProperties.INSTANCE.getHubUrl());
		driver = WebDriverFactory.getDriver(TestsProperties.INSTANCE.getDesiredCapabilities());
		driver = new FirefoxDriver(new DesiredCapabilities());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		converterSteps = new ConverterWidgetSteps(driver);
		WebDriverRunner.setWebDriver(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		WebDriverFactory.dismissDriver(driver);
	}
		
}
