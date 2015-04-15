package Visitor.visitor;

import Visitor.visitable.Flight;
import Visitor.visitable.Hotel;

public interface Visitor {
    public void visit(Hotel hotel);
    public void visit(Flight flight);
}
