package Visitor.visitor;

import Visitor.visitable.Flight;
import Visitor.visitable.Hotel;

public class CostVisitor implements Visitor {
    private double totalCostOfTrip;

    @Override
    public void visit(Hotel hotel) {
        totalCostOfTrip += (hotel.getPricePerNight() * hotel.getNightsStayed());
    }

    @Override
    public void visit(Flight flight) {
        totalCostOfTrip += (flight.getpricePerMile() * flight.getLengthOfFlight());
    }

    public double getTotalCostOfTrip(){
        return totalCostOfTrip;
    }
}
