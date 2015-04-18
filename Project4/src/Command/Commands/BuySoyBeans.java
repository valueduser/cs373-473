package Command.Commands;

//import Command.Commands.Command;

import Command.Commodities.Commodity;

//Command Object Implementation
public class BuySoyBeans implements Command{
    Commodity commodity;

    public BuySoyBeans(Commodity someCommodity){
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