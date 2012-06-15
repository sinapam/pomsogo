package controllers;

import play.*;
import play.mvc.*;
import utils.PayPalHandler;
import utils.PaymentGateway;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import models.*;

public class Application extends Controller {
	
	public static PaymentGateway payment = new PayPalHandler();
		
    public static void index() {
        render();
    }

	public static void deal_details(Long id) {
		Deal deal = Deal.findById(id);
		String paypal = "https://www.sandbox.paypal.com";
		render(deal, paypal);
	}
	
	public static void ipn() {
		Map params = request.params.data;
		// read post from PayPal system and add 'cmd'
		String str = "cmd=_notify-validate";
		Iterator<String> entries = params.entrySet().iterator();
		for (Object key : params.keySet()) {
			String value = (String) params.get(key);
			str = str + "&" + key + "=" + URLEncoder.encode(value);
		}
		
		try {
			String paymentResult = payment.handleIPN(str);
			String result;
			if(paymentResult == "VERIFIED") {
				result = "Payment confirmed";
			} else {
				result = "Payment invalid";
			}
			render(result);
		} catch (IOException e) {
			error(e);
		}
	}
}