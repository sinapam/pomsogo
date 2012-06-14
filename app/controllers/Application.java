package controllers;

import models.Deal;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.deal_details;
import views.html.index;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result dealDetails(Long id) {

		Deal deal = new Deal("Korean Tour", 13500.0);
//		Deal deal = Deal.find.byId(id);
		return ok(deal_details.render(deal.title, deal.title, deal.price));
	}
}