package Visitor.visitabe;

import Visitor.visitor.Visitor;

public class Hotel implements Visitable {
	private Visitor vistor;
	private float price;

	@Override
	public void accept(Visitor vistor) {
		this.vistor = vistor;

	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
