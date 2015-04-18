package Command;

import Command.Commodities.Commodity;
import Command.Commodities.CrudeOil;
import Command.Commodities.SoyBeans;

import java.util.ArrayList;
import java.util.List;

public class ChicagoMercantileExchange {

    public static List<Commodity> getCommodity(){
        List<Commodity> comlist = new ArrayList<Commodity>();
        comlist.add(new SoyBeans());
        comlist.add(new CrudeOil());
        return comlist;
    }
}