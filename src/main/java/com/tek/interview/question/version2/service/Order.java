package com.tek.interview.question.version2.service;

import java.util.ArrayList;
import java.util.List;

import com.tek.interview.question.version2.bean.OrderLine;

/**
 * Order class containing multiple {@link OrderLine} elements
 *
 */
public class Order implements IOrderService {

	private List<OrderLine> orderLines;

	/**
	 * Represents an Order Line
	 * 
	 * @param orderLine
	 * @throws IllegalArgumentException
	 */
	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		// BUG 1 : Initialize orderLines
		if(orderLines == null) {
			orderLines = new ArrayList<OrderLine>();
		}
		orderLines.add(o);
	}

	/**
	 * Returns number of orders added to cart
	 * 
	 * @return
	 */
	public int size() {
		return orderLines.size();
	}

	/**
	 * Get order line at given index position
	 * 
	 * @param index
	 * @return OrderLine
	 */
	public OrderLine get(int index) {
		return orderLines.get(index);
	}

	/**
	 * Clear the cart
	 */
	public void clear() {
		this.orderLines.clear();
	}
}