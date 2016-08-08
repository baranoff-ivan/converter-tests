package com.github.bia;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
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

import ru.yandex.qatools.allure.annotations.Attachment;

public class TestBase {
	
	protected WebDriver driver;
	
	protected ConverterWidgetSteps converterSteps;
	
	@Rule
	public TestWatcher screenshotOnFailure = new TestWatcher() {
	    @Override
	    protected void failed(Throwable e, Description description) {
	        makeScreenshotOnFailure();
	    }
	    
	    @Override
	    protected void finished(Description description) {
	    	if (driver != null) {
				driver.quit();
			}
	    }

	    @Attachment("Скриншот при падении")
	    public byte[] makeScreenshotOnFailure() {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
	};
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver(new DesiredCapabilities()); // TODO Сделать, чтобы можно было указать в настройках
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		converterSteps = new ConverterWidgetSteps(driver);
		WebDriverRunner.setWebDriver(driver);
	}
		
}
