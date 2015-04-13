package Command;

//Receiver Object implementation
public class SoyBeans implements Commodity{

    @Override
    public void buy() {
        System.out.println("Buying one pound of Soybeans.");
    }

    @Override
    public void sell() {
        System.out.println("Selling one pound of Soybeans.");
    }
}
