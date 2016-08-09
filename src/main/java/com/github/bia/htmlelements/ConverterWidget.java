package com.github.bia.htmlelements;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@Name("Converter Widget")
@FindBy(xpath = "//div[@data-pid='SBRF_CurrencyConv_V1']")
public class ConverterWidget extends HtmlElement {
	
	@FindBy(className = "currency-converter-date")
	private TextBlock dateLabel;

	@FindBy(xpath = "//label[@for='from']/../div")
	private CurrencyInput currencyFromInput;	
	@FindBy(xpath = "//label[@for='to']/../div")
	private CurrencyInput currencyToInput;
	
	@FindBy(className = "currency-converter-result")
	private TextBlock converterResultText;

	public void setCurrencyFrom(String currency) {
		currencyFromInput.setCurrency(currency);	
	}

	public void setCurrencyFromValue(String value) {
		currencyFromInput.setValue(value);		
	}

	public void setCurrencyTo(String currency) {
		currencyToInput.setCurrency(currency);
	}

	public void setCurrencyToValue(String value) {
		currencyToInput.setValue(value);
	}

	public String getCurrencyToValue() {
		return currencyToInput.getValue();
	}

	public String getCurrencyTo() {
		return currencyToInput.getCurrency();
	}

	public String getCurrencyFromValue() {
		return currencyFromInput.getValue();
	}

	public String getCurrencyFrom() {
		return currencyFromInput.getCurrency();
	}

	public String getCurrecyRatio() {
		return converterResultText.getText();
	}
}
