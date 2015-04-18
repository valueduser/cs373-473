package Command;

import Command.Commodities.Commodity;
import Command.Commodities.SoyBeans;

public class ChicagoMercantileExchange {

    public static Commodity getCommodity(){
        return new SoyBeans();
    }
}