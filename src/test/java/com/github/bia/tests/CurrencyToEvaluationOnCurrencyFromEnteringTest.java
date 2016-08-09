package com.github.bia.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.bia.TestBase;
import com.github.bia.util.CSVParametersReader;

@RunWith(Parameterized.class)
public class CurrencyToEvaluationOnCurrencyFromEnteringTest extends TestBase {

	@Parameters
	public static List<String[]> data() {
		return CSVParametersReader
				.getTestParameters(CurrencyToEvaluationOnCurrencyFromEnteringTest.class.getSimpleName());
	}

	private String currencyFrom;
	private String currencyFromValue;

	private String currencyToValuePattern;

	public CurrencyToEvaluationOnCurrencyFromEnteringTest(String currencyFrom, String currencyFromValue,
			String currencyToValuePattern) {
		this.currencyFrom = currencyFrom;
		this.currencyFromValue = currencyFromValue;
		this.currencyToValuePattern = currencyToValuePattern;
	}

	@Test
	public void currencyToEvaluationOnCurrencyFromEnteringTest() {
		converterSteps.openMainPage()
				.selectCurrencyFrom(currencyFrom)
				.enterCurrencyFromValue(currencyFromValue)
				.checkIfCurrencyToValueMatches(currencyToValuePattern);
	}
}
