package View;
import Integration.SaleDTO;
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
     * @param saleDTO SaleDTO of finished sale
     */
    @Override
    public void updateObserver(SaleDTO saleDTO){
        this.totalAmount += saleDTO.getTotalCost();
        printTotalAmount(this.totalAmount);
    }
    private void printTotalAmount(double totalAmount){
        System.out.println("Observer Total Amount: "+totalAmount);
    }
}
