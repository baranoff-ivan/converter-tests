package com.github.bia.sberbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.github.bia.sberbank.htmlelements.ConverterWidget;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PersonalClientMainPage extends Page {

	private ConverterWidget converter;
	
	public PersonalClientMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}

}
