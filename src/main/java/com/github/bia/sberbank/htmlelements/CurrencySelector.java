package com.github.bia.sberbank.htmlelements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@FindBy(className = "currency-converter-select")
public class CurrencySelector extends HtmlElement {
	
	private final By optionsLocator = By.xpath("//div[contains(@class,'select2-result-label')]");

	public void selectCurrency(String currency) {
		click();
		$$(optionsLocator).find(exactText(currency)).click();		
	}
}
