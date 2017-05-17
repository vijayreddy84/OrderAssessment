package com.tek.interview.question.version2.bean;

/**
 * Item Class - Represents an item, with price and description.
 */
public class Item {

	private String description;
	private float price;

	/**
	 * Constructs an Item
	 * 
	 * @param description
	 *            - Item Description
	 * @param price
	 *            - Item Price
	 */
	public Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	/**
	 * Get Item Description
	 *
	 * @return item description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get Item Price
	 *
	 * @return item price
	 */
	public float getPrice() {
		return price;
	}
}