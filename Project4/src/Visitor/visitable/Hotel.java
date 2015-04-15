package Visitor.visitable;

import Visitor.visitor.Visitor;

public class Hotel implements Visitable {
    private int pricePerNight = 120;
    private int nightsStayed;

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNightsStayed() {
        return nightsStayed;
    }

    public void setNightsStayed(int nightsStayed) {
        this.nightsStayed = nightsStayed;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
