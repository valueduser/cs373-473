package Command;

import Command.Commands.BuyCrudeOil;
import Command.Commands.BuySoyBeans;
import Command.Commands.SellCrudeOil;
import Command.Commands.SellSoyBeans;
import Command.Commodities.Commodity;

public class Client {

    public static void main(String[] args){
        Commodity newCommodity = ChicagoMercantileExchange.getCommodity().get(0);
        Commodity newCommodity2 = ChicagoMercantileExchange.getCommodity().get(1);
        BuySoyBeans buySoyCommand = new BuySoyBeans(newCommodity);
        SellSoyBeans sellSoyCommand = new SellSoyBeans(newCommodity);
        BuyCrudeOil buyCrudeCommand = new BuyCrudeOil(newCommodity2);
        SellCrudeOil sellCrudeCommand = new SellCrudeOil(newCommodity2);
        Broker giveCall1 = new Broker(buySoyCommand);
        giveCall1.callOnTelephone();
        Broker giveCall2 = new Broker(sellSoyCommand);
        giveCall2.callOnTelephone();
        Broker giveCall3 = new Broker(buySoyCommand);
        giveCall3.callOnTelephone();
        Broker giveCall4a = new Broker(buyCrudeCommand);
        giveCall4a.callOnTelephone();
        Broker giveCall4 = new Broker(buySoyCommand);
        giveCall4.callOnTelephone();
        Broker giveCall5 = new Broker(buySoyCommand);
        giveCall5.callOnTelephone();
        Broker giveCall5a = new Broker(sellCrudeCommand);
        giveCall5a.callOnTelephone();
        Broker giveCall6 = new Broker(buySoyCommand);
        giveCall6.callOnTelephone();

    }
}
