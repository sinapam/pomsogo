package th.in.pomsogo.models;

public class Deal {

	private String title;
	private double price;
	
	public Deal(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
