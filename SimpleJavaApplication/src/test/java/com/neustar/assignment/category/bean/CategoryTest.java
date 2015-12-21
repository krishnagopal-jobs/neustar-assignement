/**
 * 
 */
package com.neustar.assignment.category.bean;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.neustar.assignment.category.bean.Category;

import mockit.integration.junit4.JMockit;

/**
 * @author Krishnagopal Thogiti
 *
 */
@RunWith(JMockit.class)
public class CategoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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

	@Test
	public void testFromValueForExistingValue() {
		Category category = Category.fromValue("ANIMAL");
		Assert.assertTrue(category == Category.ANIMAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromValueForNonExistingValue() {
		Category.fromValue("FOOD");
	}

}
