package com.github.bia.sberbank.htmlelements;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//div[contains(@class, 'input-group')]")
public class CurrencyInput extends HtmlElement {
	
	private CurrencySelector currencySelector;
	
	@FindBy(className = "form_input_text")
	private TextInput input;

	public void setCurrency(String currency) {
		currencySelector.selectCurrency(currency);
	}

	public void setValue(String value) {
		input.sendKeys(value);
	}

	public String getValue() {
		return input.getText();
	}
}
