package controllers;

import play.*;
import play.api.templates.Html;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result dealDetails(String name) {
		Html html = new Html("Korean Tour");
		return ok(main.render("Korean Tour", html));
	}
}