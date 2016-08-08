package com.github.bia.htmlelements;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[contains(@class, 'input-group')]")
public class CurrencyInput extends HtmlElement {
	
	private final By optionsLocator = By.xpath("//div[contains(@class,'select2-result-label')]");	
	
	@FindBy(className = "currency-converter-select")
	private WebElement currencySelector;
	
	@FindBy(className = "form_input_text")
	private WebElement input;

	public void setCurrency(String currency) {
		$(currencySelector).click();
		$$(optionsLocator).find(exactText(currency)).click();
	}

	public void setValue(String value) {
		$(input).setValue(value);
	}

	public String getValue() {
		return $(input).val();
	}

	public String getCurrency() {
		return $(currencySelector).text();
	}
}
