package com.github.bia.sberbank.htmlelements;

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
	private CurrencyInput fromCurrencyInput;	
	@FindBy(xpath = "//label[@for='to']/../div")
	private CurrencyInput toCurrencyInput;
	
	@FindBy(className = "currency-converter-result")
	private TextBlock converterResultText;
}
