package Model;

import Integration.ItemRegistry;
import Integration.RegistryCreator;
import Integration.SaleDTO;
import Integration.ItemDTO;
public class SaleHandler {


    private ItemRegistry itemRegistry;
    private SaleDTO saleDTO;
    private double totalCost;
    private double tax;

    public SaleHandler(RegistryCreator registryCreator) {
        this.itemRegistry = registryCreator.getItemRegistry();
        this.saleDTO = new SaleDTO();
    }

    public SaleDTO addItemToSale(int itemID) {
        ItemDTO newItem = getItem(itemID);
        setNewTotalCost(newItem);
        setNewTax(newItem);
        this.saleDTO = new SaleDTO(addItemToList(newItem), this.totalCost, this.tax);
        return this.saleDTO;
    }

    public double calculateChange(double paymentAmount) {
        return (paymentAmount - this.totalCost);
    }

    public SaleDTO getSaleDTO() {
        return saleDTO;
    }

    public Receipt createReceipt() {
        Receipt receipt = new Receipt(this.saleDTO);
        return receipt;
    }

    /*Private Methods*/
    private void setNewTotalCost(ItemDTO newItem) {
        this.totalCost = this.totalCost + newItem.getTotalPrice();
    }

    private void setNewTax(ItemDTO newItem) {
        this.tax = this.tax + newItem.getTax();
    }

    private ItemDTO[] addItemToList(ItemDTO itemDTO) {

        ItemDTO[] itemDTOList = new ItemDTO[saleDTO.getItemDTO().length + 1];
        int i;
        for (i = 0; i < itemDTOList.length - 1; i++) {
            itemDTOList[i] = saleDTO.getItemDTO()[i];
        }
        itemDTOList[i] = itemDTO;
        return itemDTOList;
    }

    private ItemDTO getItem(int itemID) {
        return itemRegistry.getItem(itemID);
    }

}