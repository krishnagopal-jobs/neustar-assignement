package com.neustar.assignment.category;

import java.util.Collection;
import java.util.Map;

import com.neustar.assignment.category.bean.Category;
import com.neustar.assignment.category.bean.Item;

/**
 * @author Krishnagopal Thogiti
 *
 */
public interface InputDataHolder {

	/**
	 * This method stores the data.
	 * If the dataRow sent as parameter is of invalid type, then the method throws
	 * InvalidDataRowException.
	 * 
	 * @param dataRow
	 * @throws InvalidDataRowException
	 */
	void addDataRow(String dataRow) throws InvalidDataRowException;

	/**
	 * This method retrieves an unmodifiable collection of items for traversing
	 * 
	 * @return the items
	 */
	Collection<Item> getItems();

	/**
	 * This method returns the Category and number of items.
	 * 
	 * @return map containing Category and the number of items
	 */
	Map<Category, Integer> retrieveNumberOfItemsByCategory();

}