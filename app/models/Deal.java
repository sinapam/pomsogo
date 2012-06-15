package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Deal extends Model {
	public String title;
	public double price;

	public Deal(String title, double price) {
		this.title = title;
		this.price = price;
	}
}
