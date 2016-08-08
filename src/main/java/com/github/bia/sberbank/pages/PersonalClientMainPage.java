package com.github.bia.sberbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.github.bia.sberbank.htmlelements.ConverterWidget;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PersonalClientMainPage extends Page {

	private static final String PAGE_URL = "http://www.sberbank.ru/ru/person";
	
	private ConverterWidget converter;
	
	public PersonalClientMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}

	public static PersonalClientMainPage gotoMainPage(WebDriver driver) {
		driver.get(PAGE_URL);
		return new PersonalClientMainPage(driver);
	}

	public ConverterWidget converter() {
		return converter;
	}

}
