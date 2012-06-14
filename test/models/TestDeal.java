package models;

import static org.junit.Assert.*;

import models.Deal;

import org.junit.Test;

public class TestDeal {

	@Test
	public void test_create_new_deal() {
		String title = "Korean Tour";
		double price = 13500;
		Deal deal = new Deal(title, price);
		assertEquals(title, deal.title);
		assertEquals(price, deal.price, 0);
	}

}
