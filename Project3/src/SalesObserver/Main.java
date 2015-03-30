package SalesObserver;

/*  Sales Observer notifies members of the sales team, upper management, investors, and accounting
 *  of the sale of a widget.
 */

public class Main {
    public static void main(String[] args) {
        SalesChart salesChart = new SalesChart();

        Stakeholder rick = new Stakeholder("Rick - Accounting");
        Stakeholder sally = new Stakeholder("Sally - Sales Manager");
        Stakeholder james = new Stakeholder("James - CFO");
        Stakeholder paulyShore = new Stakeholder("Pauly Shore - Celebrity Investor");
        Stakeholder dennis = new Stakeholder("Dennis - Motivational Speaker");
        Stakeholder phoebe = new Stakeholder("Phoebe - Salesperson");

        salesChart.addObserver(rick);
        salesChart.addObserver(sally);
        salesChart.addObserver(james);
        salesChart.addObserver(paulyShore);
        salesChart.addObserver(dennis);
        salesChart.addObserver(phoebe);

        System.out.println("There are currently " + salesChart.countObservers() + " people rooting for your continued success!");

        salesChart.updateSalesFigures(26513);

        salesChart.updateSalesFigures(26514);

        salesChart.updateSalesFigures(29789);

    }
}
