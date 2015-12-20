/**
 * 
 */
package com.neustar.assignment.category.bean;

import java.io.Serializable;

/**
 * @author Krishnagopal Thogiti
 *
 */
public class Item implements Serializable {
	

	private static final long serialVersionUID = -404072301533148778L;

	private String name;
	
	private Category category;
	
	/**
	 * This method returns the name.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the category
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	
	/**
	 * This method sets category.
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (category != other.category)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [name=");
		builder.append(name);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}

	
	

}
