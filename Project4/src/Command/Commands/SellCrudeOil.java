package Command.Commands;

import Command.Commodities.Commodity;

//Command Object Implementation
public class SellCrudeOil  implements Command{
    Commodity commodity;

    public SellCrudeOil(Commodity someCommodity){
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