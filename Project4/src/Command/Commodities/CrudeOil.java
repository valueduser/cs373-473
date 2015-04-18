package Command.Commodities;

//Receiver Object implementation
public class CrudeOil implements Commodity{

    public int total = 0;

    @Override
    public void buy() {
        System.out.println("Buying one gallon of Crude Oil.");
        total++;
        stateRunningTotal();
    }

    @Override
    public void sell() {
        System.out.println("Selling one gallon of Crude Oil.");
        total--;
        stateRunningTotal();
    }

    public void stateRunningTotal() {
        System.out.println("Current total gallons of Crude Oil: " + total);
    }
}
