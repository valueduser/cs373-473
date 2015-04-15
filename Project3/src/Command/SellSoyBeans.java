package Command;

//Command Object Implementation
public class SellSoyBeans implements Command{
    Commodity commodity;

    SellSoyBeans(Commodity someCommodity){
        commodity = someCommodity;
    }


    @Override
    public void execute() {
        commodity.sell();
    }
}
