package dao;

import models.Deal;

public class DealDAOImpl implements DealDAO {

	@Override
	public Deal createNewDeal(String title, Double price) {
		Deal deal = new Deal(title, price);
		deal.save();
		return deal;
	}

	@Override
	public Deal findById(Long id) {
		return Deal.find.byId(id);
	}
}
