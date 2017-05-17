package com.tek.interview.question.version2.util;

import java.text.DecimalFormat;
import java.util.Map;

import com.tek.interview.question.version2.service.Order;

public class Calculator {

	/**
	 * DecimalFormat to round data to 2 decimal places
	 */
	private static final DecimalFormat decimalFormat = new DecimalFormat("#.00");
	
	/** 
	 * Returns the closest double for the argument with 2 decimal places.
	 * 
	 * @param value
	 * @return
	 */
	// Bug - Use DecimalFormat to round the value
	public static double rounding(double value) {
		//return ( (int) (value * 100)) / 100;
		return new Double(decimalFormat.format(value));
	}

	/**
	 * Receives a collection of orders. For each order, iterates on the order lines 
	 * and calculate the total price which is the item's (price * quantity) + taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for 
	 * this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			// BUG - Commented this line to avoid wrong calculation
			// grandtotal = 0;

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			// BUG - Iterate from 0 to (size - 1)
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				// BUG - Convert to lower case and do the comparison
				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					// Extra 5% tax on imported items
					tax = rounding(r.get(i).getItem().getPrice() * 0.15); 
				} else {
					tax = rounding(r.get(i).getItem().getPrice() * 0.10);
				}

				// BUG - Use rounding function instead of Math.floor in the program
				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + rounding(tax);

				// Print out the item's details and total price
				// BUG - Display Order quantity
				System.out.println(r.get(i).getQuantity() + " " + r.get(i).getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			// BUG - Commented this line to avoid wrong calculation
			// total = total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + rounding(total * 100) / 100);
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal * 100) / 100);
	}
}