package com.order;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.version2.bean.Item;
import com.tek.interview.question.version2.bean.OrderLine;
import com.tek.interview.question.version2.service.Order;
import com.tek.interview.question.version2.util.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	/**
	 * Test Rounding Feature
	 */
	@Test
	public void testRounding() {
		Assert.assertEquals(27.56, Calculator.rounding(27.558), 0.001);
		Assert.assertEquals(73.85, Calculator.rounding(73.854), 0.001);
		Assert.assertEquals(92.43, Calculator.rounding(92.427), 0.001);
	}

	/**
	 * Test calculate method, no assertions as method return type is void
	 * @throws Exception 
	 */
	@Test
	public void testCalculate() throws Exception {

		Map<String, Order> o = new LinkedHashMap<String, Order>();

		Order order1 = new Order();
		order1.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));
		o.put("Order 1", order1);

		Order order2 = new Order();
		order2.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));
		o.put("Order 2", order2);

		Order order3 = new Order();
		order3.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));
		o.put("Order 3", order3);

		calculator.calculate(o);
	}
}