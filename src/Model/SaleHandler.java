package Model;

import Integration.DataBaseFailureException;
import Integration.ItemNotFoundException;
import Integration.ItemRegistry;
import Integration.SaleDTO;
import Integration.ItemDTO;
import java.util.ArrayList;
import java.util.List;

public class SaleHandler {
    private ItemRegistry itemRegistry;
    private SaleDTO saleDTO;
    private ItemDTO[] itemDTO;
    private double totalCost;
    private double tax;

    List<Observer> observerList = new ArrayList<>();

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
     * @throws ItemNotFoundException if there is no item with the matching itemID
     * @throws DataBaseFailureException if the database crashes unexpectedly
     */
    public SaleDTO addItemToSale(int itemID) throws ItemNotFoundException, DataBaseFailureException {
        ItemDTO newItem = itemRegistry.getItem(itemID);
        setTotalCost(newItem);
        setTax(newItem);
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

        notifyObservers();
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
    public Receipt createReceipt() { return new Receipt(this.saleDTO);
    }

    /*Private Methods*/
    private void setTotalCost(ItemDTO newItem) {
        this.totalCost = this.totalCost + newItem.getTotalPrice();
    }

    private void setTax(ItemDTO newItem) {
        this.tax = this.tax + newItem.getTax();
    }

    /**
     * Adds a ItemDTO to the ItemDTO list
     *
     * @param itemDTO the item that is to be added to the list
     */
    private void addItemToList(ItemDTO itemDTO) {

        ItemDTO[] newItemDTOList = new ItemDTO[this.itemDTO.length + 1];
        int i;
        for (i = 0; i < newItemDTOList.length - 1; i++) {
            newItemDTOList[i] = this.itemDTO[i];
        }
        newItemDTOList[i] = itemDTO;
        this.itemDTO = newItemDTOList;
    }
    /**
     * Adds a Observer to this object
     *
     * @param observer List of observers to observe.
     */
    public void addObservers(List<Observer> observer){
        this.observerList = observer;
    }
    /**
     * Notifies all the observers in the observerList when a sale has ended
     *
     *
     */
    private void notifyObservers(){
        for(Observer observer : observerList){
            observer.updateObserver(saleDTO);
        }
    }

}