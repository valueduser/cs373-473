package Command.Commands;

import Command.Commodities.Commodity;

//Command Object Implementation
public class SellSoyBeans implements Command{
    Commodity commodity;

    public SellSoyBeans(Commodity someCommodity){
        commodity = someCommodity;
    }


    @Override
    public void execute() {
        commodity.sell();
    }

    @Override
    public void undo() {
        commodity.buy();
    }
}