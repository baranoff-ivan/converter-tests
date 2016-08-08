package com.github.bia.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.bia.TestBase;
import com.github.bia.util.CSVParametersReader;

@RunWith(Parameterized.class)
public class ReverseConversionTest extends TestBase {
	
	@Parameters
	public static List<String[]> data() {		
		return CSVParametersReader.getTestParameters(ReverseConversionTest.class.getSimpleName());
	}
	
	private String currencyFrom;
	private String currencyTo;
	private String currencyToValue;
	
	private String expectedCurrencyFromValue;
	
	public ReverseConversionTest(
			String currencyFrom, String currencyTo, 
			String currencyToValue, String expectedCurrencyFromValue) {
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.currencyToValue = currencyToValue;
		this.expectedCurrencyFromValue = expectedCurrencyFromValue;
	}
	
	@Test
	public void reverseConversionTest() {
		converterSteps.openMainPage()
			.selectCurrencyFrom(currencyFrom)
			.selectCurrencyTo(currencyTo)
			.enterCurrencyToValue(currencyToValue)
			.checkIfCurrencyFromValueEquals(expectedCurrencyFromValue);
	}
}
