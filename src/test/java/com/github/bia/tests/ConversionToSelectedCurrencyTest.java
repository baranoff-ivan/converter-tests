package com.github.bia.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.bia.TestBase;
import com.github.bia.util.CSVParametersReader;

@RunWith(Parameterized.class)
public class ConversionToSelectedCurrencyTest extends TestBase {
	
	@Parameters
	public static List<String[]> data() {		
		return CSVParametersReader.getTestParameters(ConversionToSelectedCurrencyTest.class.getSimpleName());
	}
	
	private String currencyFrom;
	private String currencyFromValue;
	private String currencyTo;
	
	private String expectedCurrencyToValue;
	
	public ConversionToSelectedCurrencyTest(
			String currencyFrom, String currencyFromValue, 
			String currencyTo, String expectedCurrencyToValue) {
		this.currencyFrom = currencyFrom;
		this.currencyFromValue = currencyFromValue;
		this.currencyTo = currencyTo;
		this.expectedCurrencyToValue = expectedCurrencyToValue;
	}
	
	@Test
	public void convertationToDefaultCurrencyTest() {
		converterSteps.openMainPage()
			.selectCurrencyFrom(currencyFrom)
			.enterCurrencyFromValue(currencyFromValue)
			.selectCurrencyTo(currencyTo)
			.checkIfCurrencyToValueEquals(expectedCurrencyToValue);
	}
}
