package com.tek.interview.question.version2.bean;

/**
 * OrderLine Class - Represents an order line with {@link Item} and quantity.
 *
 */
public class OrderLine {

	private int quantity;
	private Item item;

	/**
	 * Create an OrderLine for the given  {@link Item} & quantity
	 * 
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	public OrderLine(Item item, int quantity) throws Exception {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
		// BUG 3 - Add values to instance variables
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Get Item for this Order Line
	 *
	 * @return item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Get quantity for this Order Line
	 *
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
}