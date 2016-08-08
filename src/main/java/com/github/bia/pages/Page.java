package com.github.bia.pages;

import org.openqa.selenium.WebDriver;


/**
 * Abstract class representing parent class for all Page Objects.
 *
 */
public abstract class Page {
	
	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
