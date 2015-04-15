package Command;

import Visitor.ShoppingCart.ShoppingCart.ShoppingCart;
import Visitor.ShoppingCart.visitabe.Flight;
import Visitor.ShoppingCart.visitabe.Hotel;

import java.text.DecimalFormat;

public class Client {
    public static void main(String[] args){
        commandImp();
        visitorSetUp();
        visitorImp();
    }

    public static void commandImp(){
        Commodity newCommodity = ChicagoMercantileExchange.getCommodity();
		BuySoyBeans buyCommand = new BuySoyBeans(newCommodity);
		Broker giveCall = new Broker(buyCommand);
		giveCall.callOnTelephone();
    }
    private static ShoppingCart visitorSetUp() {
        ShoppingCart cart = new ShoppingCart();
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Flight flight3 = new Flight();
        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();

        flight1.setLengthOfFlight(1207.35);
        flight2.setLengthOfFlight(150.2);
        flight3.setLengthOfFlight(1305.6);
        hotel1.setNightsStayed(4);
        hotel2.setNightsStayed(6);

        cart.add(flight1);
        cart.add(flight2);
        cart.add(flight3);
        cart.add(hotel1);
        cart.add(hotel2);

        return cart;
    }

    private static void visitorImp() {
        ShoppingCart cart = visitorSetUp();
        DecimalFormat df = new DecimalFormat("#.00");
        double totalCost = cart.calculateCostOfTrip();
        String cost = df.format(totalCost);
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("Implementing Visitor pattern");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("User has added 3 flights and 2 hotels to cart");
        System.out.println("************************************");
        System.out.println("Cost of items in cart: $" + cost);
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
    }

}

