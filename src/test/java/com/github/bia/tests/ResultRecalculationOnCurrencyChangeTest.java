package com.github.bia.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.bia.TestBase;
import com.github.bia.util.CSVParametersReader;

@RunWith(Parameterized.class)
public class ResultRecalculationOnCurrencyChangeTest extends TestBase {
	
	@Parameters
	public static List<String[]> data() {		
		return CSVParametersReader
				.getTestParameters(ResultRecalculationOnCurrencyChangeTest.class.getSimpleName());
	}
	
	private String currencyFrom;
	private String currencyFromValue;
	private String currencyTo;
	
	public ResultRecalculationOnCurrencyChangeTest(
			String currencyFrom, String currencyFromValue, 
			String currencyTo) {
		this.currencyFrom = currencyFrom;
		this.currencyFromValue = currencyFromValue;
		this.currencyTo = currencyTo;
	}
	
	@Test
	public void resultRecalculationOnCurrencyChangeTest() {
		converterSteps.openMainPage()
			.selectCurrencyFrom(currencyFrom)
			.enterCurrencyFromValue(currencyFromValue)
			.rememberCurrencyFromValue()
			.selectCurrencyTo(currencyTo)			
			.checkIfCurrencyFromValueChanged();
	}
}
