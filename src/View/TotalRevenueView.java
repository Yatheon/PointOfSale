package View;
import Model.Observer;

/**
 * A observer class used to observe the total revenue of the sale.
 */

public class TotalRevenueView implements Observer {
    private double totalAmount;
    public TotalRevenueView(){
        totalAmount = 0;
    }
    /**
     * Is called from saleHandler when a sale has ended.
     *
     * @param totalAmount the total amount of cash that the customer has to pay to the cashier
     */
    @Override
    public void updateObserver(double totalAmount){
        this.totalAmount += totalAmount;
        printTotalAmount(this.totalAmount);
    }
    private void printTotalAmount(double totalAmount){
        System.out.println("Observer Total Amount: "+totalAmount);
    }
}
