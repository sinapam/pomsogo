package th.in.pomsogo.models;

import static org.junit.Assert.*;
import th.in.pomsogo.models.Deal;

import org.junit.Test;

public class TestDeal {

	@Test
	public void test_create_new_deal() {
		String title = "Korean Tour";
		double price = 13500;
		Deal deal = new Deal(title, price);
		assertEquals(title, deal.getTitle());
		assertEquals(price, deal.getPrice(), 0);
	}

}
