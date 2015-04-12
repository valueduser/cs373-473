package Visitor.visitor;

import Visitor.visitabe.Flight;
import Visitor.visitabe.Hotel;

public interface Visitor {
	public void visit(Hotel hotel);
	public void visit(Flight flight);
}
