package Model;
import Integration.ItemDTO;
import Integration.SaleDTO;
public class Receipt {
    private String[] receipt;

    /**
     *
     * Creates the receipt object that contains a String with information that the printer can print out.
     *
     * @param saleDTO The information of the sale
     */
    Receipt(SaleDTO saleDTO){
        ItemDTO[] itemDTO = saleDTO.getItemDTO();
        this.receipt = new String[itemDTO.length+3];
        int i = 0;
        for(; i< itemDTO.length; i++) {
            this.receipt[i] = itemDTO[i].getTotalPrice()+"  "+ itemDTO[i].getName();
        }
        this.receipt[i++] = "Total Cost: "+saleDTO.getTotalCost();
        this.receipt[i++] = "Tax: "+saleDTO.getTax();
        this.receipt[i++] = "Have a nice day mr. customer, plz come back we need you!";
    }

    public String[] getReceipt() {
        return receipt;
    }
}
