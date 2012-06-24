package controllers;

import play.*;
import play.mvc.*;
import utils.PaymentGateway;

import java.io.IOException;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static PaymentGateway payment;

	public static void index() {
        render();
    }

	public static void deal_details(Long id) {
		Deal deal = Deal.findById(id);
		render(deal);
	}
	
	public static void ipn() {
		String jsonString = "Order not created";
		try {
			String queryString = "cmd=_notify-validate&" + request.querystring;
			if(payment.handleIPN(queryString) == "VERIFIED") {
				jsonString = "Order created";
			} else {
				jsonString = "Order not created";
			}
		} catch (IOException e) {
			error(e);
		}
		renderJSON(jsonString);
	}
}