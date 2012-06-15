package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

	public static void deal_details(Long id) {
		Deal deal = Deal.findById(id);
		String paypal = "https://www.sandbox.paypal.com";
		render(deal, paypal);
	}    
}