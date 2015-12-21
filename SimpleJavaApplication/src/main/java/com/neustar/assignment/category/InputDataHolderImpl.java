/**
 * 
 */
package com.neustar.assignment.category;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neustar.assignment.category.bean.Category;
import com.neustar.assignment.category.bean.Item;

/**
 * @author Krishnagopal Thogiti
 *
 */
public class InputDataHolderImpl implements InputDataHolder {

	private Set<Item> items;
	private static Logger logger = LoggerFactory.getLogger(InputDataHolderImpl.class);

	public InputDataHolderImpl() {
		this.items = new LinkedHashSet<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neustar.assignment.category.InputDataHolder#addDataRow(java.lang.
	 * String)
	 */
	@Override
	public void addDataRow(String dataRow) throws InvalidDataRowException {

		logger.debug("addDataRow(String dataRow) ---  start");
		dataRow = dataRow.trim();

		String[] categoryItemArray = dataRow.split("\\s", 2);

		if (categoryItemArray.length != 2) {
			throw new InvalidDataRowException();
		}

		Item item = new Item();
		try {
			item.setCategory(Category.fromValue(categoryItemArray[0]));
		} catch (IllegalArgumentException e) {
			throw new InvalidDataRowException(e);
		}
		item.setName(categoryItemArray[1]);

		items.add(item);
		logger.debug("addDataRow(String dataRow) ---  end");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neustar.assignment.category.InputDataHolder#getItems()
	 */
	@Override
	public Collection<Item> getItems() {

		logger.debug("getItems()");
		return Collections.unmodifiableCollection(items);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neustar.assignment.category.InputDataHolder#
	 * retrieveNumberOfItemsByCategory()
	 */
	@Override
	public Map<Category, Integer> retrieveNumberOfItemsByCategory() {

		logger.debug("retrieveNumberOfItemsByCategory() -- start");
		Map<Category, Integer> categoryNumberMap = new TreeMap<>();

		for (Item item : items) {
			Category category = item.getCategory();
			int numberOfItems = 0;
			if (categoryNumberMap.get(category) != null) {
				numberOfItems = categoryNumberMap.get(category);
			}
			categoryNumberMap.put(category, ++numberOfItems);
		}
		logger.debug("retrieveNumberOfItemsByCategory() -- end");
		return categoryNumberMap;
	}

}
