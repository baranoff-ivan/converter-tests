package com.github.bia.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.bia.TestBase;
import com.github.bia.util.CSVParametersReader;

@RunWith(Parameterized.class)
public class DisplayCurrencyRatioTest extends TestBase {
	
	@Parameters
	public static List<String[]> data() {		
		return CSVParametersReader
				.getTestParameters(DisplayCurrencyRatioTest.class.getSimpleName());
	}
	
	private String currencyFrom;
	private String currencyTo;
	
	private String currencyRatioPattern;
	
	public DisplayCurrencyRatioTest(
			String currencyFrom, String currencyTo, 
			String currencyRatioPattern) {
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.currencyRatioPattern = currencyRatioPattern;
	}
	@Test
	public void displayCurrencyRatioTest() {
		converterSteps.openMainPage()
			.selectCurrencyFrom(currencyFrom)
			.selectCurrencyTo(currencyTo)
			.checkIfCurrencyRatioTextMatches(currencyRatioPattern);
	}
}
