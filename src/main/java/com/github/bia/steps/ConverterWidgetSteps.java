package com.github.bia.steps;

import org.openqa.selenium.WebDriver;

import com.github.bia.pages.PersonalClientMainPage;

import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ConverterWidgetSteps {
	private WebDriver driver;

	private PersonalClientMainPage mainPage;

	private String rememberedCurrencyFromValue;

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
		assertEquals("Некорректное значение второй валюты", expectedValue, mainPage.converter().getCurrencyToValue());
		return this;
	}

	@Step("Проверить, что значение первой валюты равно [{0}]")
	public ConverterWidgetSteps checkIfCurrencyFromValueEquals(String expectedValue) {
		assertEquals("Некорректное значение первой валюты", expectedValue, mainPage.converter().getCurrencyFromValue());
		return this;
	}

	@Step("Проверить, что текст соотношения между валютами соответствует шаблону [{0}]")
	public ConverterWidgetSteps checkIfCurrencyRatioTextMatches(String pattern) {
		assertThat("Текст соотношения между валютами не соответствует шаблону", mainPage.converter().getCurrecyRatio(),
				matchesPattern(pattern));
		return this;
	}

	@Step("Проверить, что значение второй валюты соответствует шаблону [{0}]")
	public ConverterWidgetSteps checkIfCurrencyToValueMatches(String currencyToValuePattern) {
		assertThat("Значение второй валюты не соответствует шаблону", mainPage.converter().getCurrencyToValue(),
				matchesPattern(currencyToValuePattern));
		return this;
	}

	@Step("Запомнить текущее значение второй валюты")
	public ConverterWidgetSteps rememberCurrencyFromValue() {
		rememberedCurrencyFromValue = mainPage.converter().getCurrencyToValue();
		return this;
	}

	@Step("Проверить, что значение второй валюты изменилось")
	public ConverterWidgetSteps checkIfCurrencyFromValueChanged() {
		assertNotEquals("Значение второй залюты не изменилось", rememberedCurrencyFromValue, 
				mainPage.converter().getCurrencyToValue());
		return this;
	}
}
