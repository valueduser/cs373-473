package Visitor.visitabe;

import Visitor.visitor.Visitor;

public class Flight implements Visitable {
	private double pricePerMile = 15.23;
	private double lengthOfFlight;

	@Override
	public void accept(Visitor vistor) {
		vistor.visit(this);
		
	}

	public double getpricePerMile() {
		return pricePerMile;
	}

	public double getLengthOfFlight() {
		return lengthOfFlight;
	}

	public void setLengthOfFlight(double lengthOfFlight) {
		this.lengthOfFlight = lengthOfFlight;
	}
}
