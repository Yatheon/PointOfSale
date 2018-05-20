package Controller;

import Integration.DataBaseFailureException;
import Integration.ItemNotFoundException;
import Integration.ExternalComController;
import Integration.Printer;
import Integration.RegistryCreator;
import Integration.SaleDTO;
import Model.Observer;
import Model.SaleHandler;
import Exception.LogHandler;

public class Controller {
    private SaleHandler saleHandler;
    private RegistryCreator registryCreator;
    private Printer printer;
    private ExternalComController externalComController;
    private LogHandler logHandler;

    public Controller(RegistryCreator registryCreator, Printer printer, ExternalComController externalComController, LogHandler logHandler) {
        this.registryCreator = registryCreator;
        this.printer = printer;
        this.externalComController = externalComController;
        this.logHandler = logHandler;

    }

    /**
     * Initiates the sale process
     */
    public void startSale() {
        this.saleHandler = new SaleHandler(this.registryCreator.getItemRegistry());
    }

    /**
     * Adds a item to the saleDTO and updates it
     *
     * @param itemID the ID of the scanned object that is to be sold
     * @return a updated saleDTO that has the added item
     *
     */
    public SaleDTO enterItem(int itemID)throws ItemNotFoundException{
        try {
            return saleHandler.addItemToSale(itemID);
        } catch (DataBaseFailureException e){
            logHandler.logExeption(e);
            throw new ItemNotFoundException("The item with the ID: '"+ itemID+"' could not be found." , itemID);
            }
        }


    /**
     * Ends the current sale and notifies the cashier of the change that is to be given to the costumer.
     *
     * @param paymentAmount the amount that the costumer has payed
     * @return the change that the cashier is to give back to the costumer
     */
    public double finishSale(double paymentAmount) {
        printer.printReceipt(saleHandler.createReceipt());
        externalComController.sendSaleInformation(saleHandler.getSaleDTO());
        return saleHandler.calculateChange(paymentAmount);
    }
    /**
     * Tells the saleHandler to add a observer
     *
     * @param observer the object that is to observe SaleHandler
     */
    public void addSaleHandlerObserver(Observer observer){
        saleHandler.addObserver(observer);
    }
}
