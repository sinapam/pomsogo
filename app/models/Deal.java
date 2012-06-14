package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Deal extends Model {

	@Id
	public Long id;

	@Constraints.Required
	public String title;

	@Constraints.Required
	public double price;

	public Deal(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public static Finder<Long, Deal> find = new Finder<Long, Deal>(Long.class,
			Deal.class);
}
