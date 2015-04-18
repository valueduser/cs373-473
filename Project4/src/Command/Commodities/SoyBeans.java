package Command.Commodities;

//Receiver Object implementation
public class SoyBeans implements Commodity{

    public int total = 0;

    @Override
    public void buy() {
        System.out.println("Buying one pound of Soybeans.");
        total++;
        stateRunningTotal();
    }

    @Override
    public void sell() {
        System.out.println("Selling one pound of Soybeans.");
        total--;
        stateRunningTotal();
    }

    public void stateRunningTotal() {
        System.out.println("Current total pounds of Soybeans: " + total);
    }
}
