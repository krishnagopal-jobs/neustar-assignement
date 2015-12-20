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

import com.neustar.assignment.category.bean.Category;
import com.neustar.assignment.category.bean.Item;

/**
 * @author Krishnagopal Thogiti
 *
 */
public class InputDataHolderImpl implements InputDataHolder {

	private Set<Item> items;

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

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neustar.assignment.category.InputDataHolder#getItems()
	 */
	@Override
	public Collection<Item> getItems() {

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

		Map<Category, Integer> categoryNumberMap = new TreeMap<>();

		for (Item item : items) {
			Category category = item.getCategory();
			int numberOfItems = 0;
			if (categoryNumberMap.get(category) != null) {
				numberOfItems = categoryNumberMap.get(category);
			}
			categoryNumberMap.put(category, ++numberOfItems);
		}

		return categoryNumberMap;
	}

}
