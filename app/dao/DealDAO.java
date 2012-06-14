package dao;

import models.Deal;

public interface DealDAO {

	public abstract Deal createNewDeal(String title, Double price);
	public abstract Deal findById(Long id);

}