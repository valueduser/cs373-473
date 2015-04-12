package Visitor.visitabe;

import Visitor.visitor.Visitor;

public class Hotel implements Visitable {
	private int pricePerNight = 120;
	private int nightsStayed;
	

	@Override
	public void accept(Visitor vistor) {
		vistor.visit(this);

	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public int getNightsStayed() {
		return nightsStayed;
	}

	public void setNightsStayed(int nightsStayed) {
		this.nightsStayed = nightsStayed;
	}
}
