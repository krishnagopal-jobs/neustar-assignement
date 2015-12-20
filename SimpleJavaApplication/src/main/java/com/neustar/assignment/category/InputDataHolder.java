package com.neustar.assignment.category;

import java.util.Collection;
import java.util.Map;

import com.neustar.assignment.category.bean.Category;
import com.neustar.assignment.category.bean.Item;

public interface InputDataHolder {

	void addDataRow(String dataRow) throws InvalidDataRowException;

	/**
	 * This method retrieves an unmodifiable collection of items for traversing
	 * 
	 * @return the items
	 */
	Collection<Item> getItems();

	Map<Category, Integer> retrieveNumberOfItemsByCategory();

}