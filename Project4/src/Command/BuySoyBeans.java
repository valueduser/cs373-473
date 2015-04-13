package Command;

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
}
