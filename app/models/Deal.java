package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Deal extends Model {
	public String title;
	public double price;
	public String desc;

	public Deal(String title, double price, String desc) {
		this.title = title;
		this.price = price;
		this.desc = desc;
	}
}
