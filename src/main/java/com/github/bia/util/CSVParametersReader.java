package com.github.bia.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Вспомогательный класс для чтения параметров теста из CSV-файла.
 */
public class CSVParametersReader {
	private final static String PARAMETER_FILE_PATH = "src/test/resources/%s.csv";
	private final static String SEPARATOR = "(\\s*,\\s*)|(\\s*$)";

	private CSVParametersReader() {
	}

	/**
	 * Читает параметры из соответствующего данному тестовому классу файла.
	 * 
	 * Файл параметров должен иметь название, идентичное названию тестового класса, но
	 * записанному строчными буквами с символом нижнего подчеркивания в качестве
	 * разделителя.
	 * 
	 * @param testName - имя тестового класса
	 * @return параметры теста
	 */
	public static List<String[]> getTestParameters(String testName) {
		List<String[]> parameters = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(Paths.get(String.format(PARAMETER_FILE_PATH, getFileName(testName))))) {
				parameters.add(line.split(SEPARATOR));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parameters;
	}

	/**
	 * Преобразует имя класса в строчные буквы с разделителем в виде
	 * подчеркивания. 
	 * Например: SomeTestClass -> some_test_class
	 * 
	 * @param testName - имя тестового класса
	 * @return преобразованное имя
	 */
	private static String getFileName(String testName) {
		String fileName = testName.replaceAll("([A-Z])", "_$1").replaceFirst("_(.*)", "$1");
		return fileName.toLowerCase();
	}

}
