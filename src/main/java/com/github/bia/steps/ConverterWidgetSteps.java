package com.github.bia.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.github.bia.pages.PersonalClientMainPage;

import ru.yandex.qatools.allure.annotations.Step;

public class ConverterWidgetSteps {
	private WebDriver driver;
	
	private PersonalClientMainPage mainPage;
	
	public ConverterWidgetSteps(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Открыть главную страницу")
	public ConverterWidgetSteps openMainPage() {
		mainPage = PersonalClientMainPage.gotoMainPage(driver);
		return this;
	}

	@Step("Выбрать первую валюту: [{0}]")
	public ConverterWidgetSteps selectCurrencyFrom(String currency) {
		if (mainPage.converter().getCurrencyFrom().equals(currency)) {
			return this;
		}
		mainPage.converter().setCurrencyFrom(currency);
		return this;
	}

	@Step("Ввести значение [{0}] для первой валюты")
	public ConverterWidgetSteps enterCurrencyFromValue(String value) {
		mainPage.converter().setCurrencyFromValue(value);
		return this;
	}

	@Step("Выбрать вторую валюту: [{0}]")
	public ConverterWidgetSteps selectCurrencyTo(String currency) {
		if (mainPage.converter().getCurrencyTo().equals(currency)) {
			return this;
		}
		mainPage.converter().setCurrencyTo(currency);
		return this;
	}
	
	@Step("Ввести значение [{0}] для второй валюты")
	public ConverterWidgetSteps enterCurrencyToValue(String value) {
		mainPage.converter().setCurrencyToValue(value);
		return this;
	}

	@Step("Проверить, что значение второй валюты равно [{0}]")
	public ConverterWidgetSteps checkIfCurrencyToValueEquals(String expectedValue) {
		Assert.assertEquals("Incorrect CurrencyTo value:", expectedValue, 
				mainPage.converter().getCurrencyToValue());
		return this;
	}

	@Step("Проверить, что значение первой валюты равно [{0}]")
	public ConverterWidgetSteps checkIfCurrencyFromValueEquals(String expectedValue) {
		Assert.assertEquals("Incorrect CurrencyFrom value:", expectedValue, 
				mainPage.converter().getCurrencyFromValue());
		return this;
	}
}
