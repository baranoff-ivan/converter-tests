package com.github.bia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.github.bia.htmlelements.ConverterWidget;
import com.github.bia.util.TestsProperties;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PersonalClientMainPage extends Page {

	private ConverterWidget converter;
	
	public PersonalClientMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}

	public static PersonalClientMainPage gotoMainPage(WebDriver driver) {
		driver.get(TestsProperties.INSTANCE.getMainPageUrl());
		return new PersonalClientMainPage(driver);
	}

	public ConverterWidget converter() {
		return converter;
	}

}
