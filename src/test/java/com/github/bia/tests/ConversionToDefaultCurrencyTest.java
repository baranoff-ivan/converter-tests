package com.github.bia.tests;

import org.junit.Test;

import com.github.bia.TestBase;

public class ConversionToDefaultCurrencyTest extends TestBase {
	
	@Test
	public void convertationToDefaultCurrencyTest() {
		converterSteps.openMainPage()
			.selectCurrencyFrom("RUB")
			.enterCurrencyFromValue("123.4")
			.checkIfCurrencyToValueEquals("1.82");
	}
}
