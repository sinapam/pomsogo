package controllers;

import dao.DealDAO;
import dao.DealDAOImpl;
import models.Deal;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.deal_details;
import views.html.index;

public class Application extends Controller {
	private static DealDAO dao = new DealDAOImpl();
	
	public static void setDealDAO(DealDAO dao) {
		Application.dao = dao;
	}

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result dealDetails(Long id) {
		Deal deal = dao.findById(id);
		return ok(deal_details.render(deal.title, deal.title, deal.price));
	}
}