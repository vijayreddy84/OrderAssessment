package com.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.version2.bean.Item;
import com.tek.interview.question.version2.bean.OrderLine;
import com.tek.interview.question.version2.service.Order;

public class OrderTest {

	private Order order;

	@Before
	public void init() {
		order = new Order();
	}

	/**
	 * Tests add and size methods
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		// Add OrderLines to Order
		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		// Check collection size
		Assert.assertTrue(order.size() > 0);
		Assert.assertEquals(3, order.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddUsingNull() throws Exception {
		order.add(null);
	}

	/**
	 * Tests Order Get method
	 */
	@Test
	public void testGet() throws Exception {
		Item item1 = new Item("book", (float) 12.49);
		Item item2 = new Item("music CD", (float) 14.99);

		OrderLine orderLine1 = new OrderLine(item1, 2);
		OrderLine orderLine2 = new OrderLine(item2, 4);

		// Add OrderLines to the Order
		order.add(orderLine1);
		order.add(orderLine2);

		// verify order lines
		Assert.assertNotNull(order.get(0));
		Assert.assertEquals(orderLine1, order.get(0));
		Assert.assertEquals(orderLine2, order.get(1));

		// verify items
		Assert.assertNotNull(order.get(0).getItem());
		Assert.assertNotNull(order.get(1).getItem());
		Assert.assertEquals(item1, order.get(0).getItem());
		Assert.assertEquals(item2, order.get(1).getItem());

		// verify item description
		Assert.assertEquals("book", order.get(0).getItem().getDescription());
		Assert.assertEquals("music CD", order.get(1).getItem().getDescription());

		// verify order quantity
		Assert.assertEquals(2, order.get(0).getQuantity());
		Assert.assertEquals(4, order.get(1).getQuantity());

		// verify item price
		Assert.assertEquals(12.49f, order.get(0).getItem().getPrice(), 0.001);
		Assert.assertEquals(14.99f, order.get(1).getItem().getPrice(), 0.001);
	}
}