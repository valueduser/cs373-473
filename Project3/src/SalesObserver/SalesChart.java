package SalesObserver;

import java.util.Observable;

public class SalesChart extends Observable{
    private int salesFigures;

    public void updateSalesFigures(int newSalesFigures){
        salesFigures = newSalesFigures;
        setChanged();
        notifyObservers(salesFigures);
    }
}
