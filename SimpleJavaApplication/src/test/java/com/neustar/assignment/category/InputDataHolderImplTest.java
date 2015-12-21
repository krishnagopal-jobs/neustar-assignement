/**
 * 
 */
package com.neustar.assignment.category;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.neustar.assignment.category.bean.Category;
import com.neustar.assignment.category.bean.Item;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

/**
 * @author Krishnagopal Thogiti
 *
 */
@RunWith(JMockit.class)
public class InputDataHolderImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.neustar.assignment.category.InputDataHolderImpl#InputDataHolderImpl()}.
	 */
	@Test
	public void testInputDataHolderImpl(@Mocked LinkedHashSet<Item> linkedHashSet) {
		
		new Expectations(){{

		}};
		
		InputDataHolder inputDataHolder= new InputDataHolderImpl();
		
		assertNotNull(inputDataHolder.getItems());
		
		new Verifications() {{
			new LinkedHashSet<>();
			times = 1;
		}};
	}

	/**
	 * Test method for {@link com.neustar.assignment.category.InputDataHolderImpl#addDataRow(java.lang.String)}.
	 * @throws InvalidDataRowException 
	 */
	@Test
	public void testAddDataRow4Splitting() throws InvalidDataRowException {
		String dataRow = "OTHER How are you?";
		InputDataHolder inputDataHolder= new InputDataHolderImpl();
		inputDataHolder.addDataRow(dataRow);
		Collection<Item> items = inputDataHolder.getItems();
		Assert.assertTrue(items.size() == 1);
		Item item = null;
		for (Item tempItem : items) {
			item = tempItem;
		}
		Assert.assertEquals(Category.OTHER, item.getCategory());
		Assert.assertEquals("How are you?", item.getName());
	}

	@Test
	public void testAddDataRow4TrimmingNSplitting() throws InvalidDataRowException {
		String dataRow = " OTHER How are you? ";
		InputDataHolder inputDataHolder= new InputDataHolderImpl();
		inputDataHolder.addDataRow(dataRow);
		Collection<Item> items = inputDataHolder.getItems();
		Assert.assertTrue(items.size() == 1);
		Item item = null;
		for (Item tempItem : items) {
			item = tempItem;
		}
		Assert.assertEquals(Category.OTHER, item.getCategory());
		Assert.assertEquals("How are you?", item.getName());
	}
	
	@Test(expected = InvalidDataRowException.class)
	public void testAddDataRow4UnknownCategory(@Mocked Category category) throws InvalidDataRowException {
		
		new Expectations(){{ 
			Category.fromValue(anyString);
			result = new IllegalArgumentException();
		}};
		
		String dataRow = " OTHER How are you? ";
		InputDataHolder inputDataHolder= new InputDataHolderImpl();
		inputDataHolder.addDataRow(dataRow);
		
	}
	
	/**
	 * Test method for {@link com.neustar.assignment.category.InputDataHolderImpl#getItems()}.
	 * @throws InvalidDataRowException 
	 */
	@Test
	public void testGetItems() throws InvalidDataRowException {
		String dataRow = " OTHER How are you? ";
		InputDataHolder inputDataHolder= new InputDataHolderImpl();
		inputDataHolder.addDataRow(dataRow);
		Collection<Item> items = inputDataHolder.getItems();
		Assert.assertTrue(items.size() == 1);
		Item item = null;
		for (Item tempItem : items) {
			item = tempItem;
		}
		Assert.assertEquals(Category.OTHER, item.getCategory());
		Assert.assertEquals("How are you?", item.getName());
	}

	/**
	 * Test method for {@link com.neustar.assignment.category.InputDataHolderImpl#retrieveNumberOfItemsByCategory()}.
	 */
	@Test
	public void testRetrieveNumberOfItemsByCategory() {
		String[] datarows = {
			"OTHER Howday", "PLACE Rowsd", "OTHER shitake mashroom"	
		};
		
		InputDataHolder inputDataHolder = new InputDataHolderImpl();
		for (String datarow : datarows) {
			try {
				inputDataHolder.addDataRow(datarow);
			} catch (InvalidDataRowException e) {
				fail("All the rows are valid.");
			}
		}
		
		Map<Category, Integer> itemsCategoryMap = inputDataHolder.retrieveNumberOfItemsByCategory();
		Assert.assertEquals(2, itemsCategoryMap.size());
		
		Assert.assertEquals(2,(int)itemsCategoryMap.get(Category.OTHER));
		Assert.assertEquals(1,(int)itemsCategoryMap.get(Category.PLACE));
		
	}

}
