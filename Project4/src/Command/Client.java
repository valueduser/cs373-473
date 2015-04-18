package Command;

import Command.Commands.BuySoyBeans;
import Command.Commands.SellSoyBeans;
import Command.Commodities.Commodity;

public class Client {

    public static void main(String[] args){
        Commodity newCommodity = ChicagoMercantileExchange.getCommodity();
        BuySoyBeans buyCommand = new BuySoyBeans(newCommodity);
        SellSoyBeans sellCommand = new SellSoyBeans(newCommodity);
        Broker giveCall1 = new Broker(buyCommand);
        giveCall1.callOnTelephone();
        Broker giveCall2 = new Broker(sellCommand);
        giveCall2.callOnTelephone();
        Broker giveCall3 = new Broker(buyCommand);
        giveCall3.callOnTelephone();
        Broker giveCall4 = new Broker(buyCommand);
        giveCall4.callOnTelephone();
        Broker giveCall5 = new Broker(buyCommand);
        giveCall5.callOnTelephone();
        Broker giveCall6 = new Broker(buyCommand);
        giveCall6.callOnTelephone();
    }
}
