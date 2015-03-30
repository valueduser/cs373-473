package SalesObserver;

import java.util.Observable;
import java.util.Observer;

public class Stakeholder implements Observer{
    private String name;

    public Stakeholder(String stakeholderName){
        name = stakeholderName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hello " + name + ",");
        System.out.println("The sales figures have been updated.");
        System.out.println("The current sales to date are now: " + arg +"\n");
    }
}
