package com.github.bia.tests;

import org.junit.Test;

import com.github.bia.TestBase;

public class ConvertationToDefaultCurrencyTest extends TestBase {
	
	@Test
	public void convertationToDefaultCurrencyTest() {
		converterSteps.openMainPage()
			.selectCurrencyFrom("RUB")
			.enterCurrencyFromValue("123.4")
			.selectCurrencyTo("USD")
			.checkIfCurrencyToValueEquals("1.82");
	}
}
