package com.tek.interview.question.version2.service;

import com.tek.interview.question.version2.bean.OrderLine;

public interface IOrderService {

	/**
	 * Represents an Order Line
	 * 
	 * @param orderLine
	 * @throws IllegalArgumentException
	 */
	void add(OrderLine orderLine) throws Exception;

	/**
	 * Returns number of orders added to cart
	 * 
	 * @return
	 */
	int size();

	/**
	 * Get order line at given index position
	 * 
	 * @param index
	 * @return OrderLine
	 */
	OrderLine get(int index);

	/**
	 * Clear the cart
	 */
	void clear();

}