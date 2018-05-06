package Model;

import Integration.ItemRegistry;
import Integration.RegistryCreator;
import Integration.SaleDTO;
import Integration.ItemDTO;

public class SaleHandler {
    private ItemRegistry itemRegistry;
    private SaleDTO saleDTO;
    private ItemDTO[] itemDTO;
    private double totalCost;
    private double tax;

    /**
     * Creates a new instance, a object that handles sale logic.
     *
     * @param itemRegistry object with all items
     */
    public SaleHandler(ItemRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
        this.saleDTO = new SaleDTO();
        this.itemDTO = new ItemDTO[0];
    }

    /**
     * Adds a item to the SaleDTO and updates all the content of the DTO
     *
     * @param itemID the id of the scanned item that is to be added to the sale
     * @return a new SaleDTO that has the added item
     */
    public SaleDTO addItemToSale(int itemID) {
        ItemDTO newItem = itemRegistry.getItem(itemID);
        setNewTotalCost(newItem);
        setNewTax(newItem);
        addItemToList(newItem);
        this.saleDTO = new SaleDTO(this.itemDTO, this.totalCost, this.tax);
        return this.saleDTO;
    }

    /**
     * Calculate change based on payment amount and running total
     *
     * @param paymentAmount amount entered into the system at end of sale
     * @return change calculated from payment amount and running total
     */
    public double calculateChange(double paymentAmount) {
        return (paymentAmount - this.totalCost);
    }

    /**
     * Get method for Salehandler to retrieve stored SaleDTO
     *
     * @return Salehandler object own SaleDTO
     */
    public SaleDTO getSaleDTO() {
        return saleDTO;
    }

    /**
     * Create receipt from Salehandlers stored SaleDTO
     *
     * @return receipt object
     */
    public Receipt createReceipt() {
        return new Receipt(this.saleDTO);
    }

    /*Private Methods*/
    private void setNewTotalCost(ItemDTO newItem) {
        this.totalCost = this.totalCost + newItem.getTotalPrice();
    }

    private void setNewTax(ItemDTO newItem) {
        this.tax = this.tax + newItem.getTax();
    }

    /**
     * Adds a ItemDTO to the ItemDTO list
     *
     * @param itemDTO the item that is to be added to the list
     * @return a updated itemDTO list with the added item
     */
    private ItemDTO[] addItemToList(ItemDTO itemDTO) {

        ItemDTO[] newItemDTOList = new ItemDTO[this.itemDTO.length + 1];
        int i;
        for (i = 0; i < newItemDTOList.length - 1; i++) {
            newItemDTOList[i] = this.itemDTO[i];
        }
        newItemDTOList[i] = itemDTO;
        this.itemDTO = newItemDTOList;
        return this.itemDTO;
    }

}