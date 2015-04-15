package Visitor;

import Visitor.visitable.Visitable;
import Visitor.visitor.CostVisitor;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Visitable> items = new ArrayList<Visitable>();

    public double calculateCostOfTrip(){
        CostVisitor vistor = new CostVisitor();
        for(Visitable item: items){
            item.accept(vistor);
        }
        double costOfTrip = vistor.getTotalCostOfTrip();
        return costOfTrip;
    }

    public void add(Visitable item){
        items.add(item);
    }
}