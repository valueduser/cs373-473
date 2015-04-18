package Command.Commands;

import Command.Commodities.Commodity;

//Command Object Implementation
public class BuyCrudeOil implements Command{
    Commodity commodity;

    public BuyCrudeOil(Commodity someCommodity){
        commodity = someCommodity;
    }


    @Override
    public void execute() {
        commodity.buy();
    }

    @Override
    public void undo() {
        commodity.sell();
    }
}