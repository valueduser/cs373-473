package Visitor.visitable;

import Visitor.visitor.Visitor;

public class Flight implements Visitable {
    private double pricePerMile = 15.23;
    private double lengthOfFlight;

    public double getpricePerMile() {
        return pricePerMile;
    }

    public double getLengthOfFlight() {
        return lengthOfFlight;
    }

    public void setLengthOfFlight(double lengthOfFlight) {
        this.lengthOfFlight = lengthOfFlight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
