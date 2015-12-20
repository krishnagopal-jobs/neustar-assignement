package com.neustar.assignment;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import com.neustar.assignment.category.InputDataHolder;
import com.neustar.assignment.category.InputFileReader;
import com.neustar.assignment.category.InputFileReaderImpl;
import com.neustar.assignment.category.bean.Category;
import com.neustar.assignment.category.bean.Item;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		String fileName = null;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter the relative path of the file:");
			fileName = scanner.nextLine();
		}

		InputFileReader inputFileReader = new InputFileReaderImpl(fileName);// ("src/test/resources/SampleInputFile.txt");
		inputFileReader.readFile();
		InputDataHolder inputDataHolder = inputFileReader.getInputDataHolder();
		Map<Category, Integer> numberOfItemsByCategory = inputDataHolder.retrieveNumberOfItemsByCategory();

		System.out.printf("%-15s%-15s\n", "CATEGORY", "COUNT");
		for (Category category : numberOfItemsByCategory.keySet()) {
			System.out.printf("%-15s%-15s\n", category, numberOfItemsByCategory.get(category));
		}

		Collection<Item> items = inputDataHolder.getItems();
		for (Item item : items) {
			System.out.printf("%-15s%-15s\n", item.getCategory(), item.getName());
		}

	}
}
