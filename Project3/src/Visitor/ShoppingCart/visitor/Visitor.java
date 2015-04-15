package Visitor.ShoppingCart.visitor;

import Visitor.ShoppingCart.visitabe.Flight;
import Visitor.ShoppingCart.visitabe.Hotel;

public interface Visitor {
    public void visit(Hotel hotel);
    public void visit(Flight flight);
}
