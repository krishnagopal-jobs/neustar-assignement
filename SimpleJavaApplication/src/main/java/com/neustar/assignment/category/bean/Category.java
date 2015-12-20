/**
 * 
 */
package com.neustar.assignment.category.bean;

/**
 * @author Krishnagopal Thogiti
 *
 */
public enum Category {

	PERSON, PLACE, ANIMAL, COMPUTER, OTHER;


	public String value() {
		return name();
	}

	public static Category fromValue(String name) {
		return valueOf(name);
	}

}
