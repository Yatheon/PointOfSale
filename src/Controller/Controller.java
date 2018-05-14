package Controller;

import Exceptions.DataBaseFailureException;
import Exceptions.ErrorMessageHandler;
import Exceptions.ItemNotFoundException;
import Exceptions.LogHandler;
import Integration.ExternalComController;
import Integration.Printer;
import Integration.RegistryCreator;
import Integration.SaleDTO;
import Model.SaleHandler;

public class Controller {
    private SaleHandler saleHandler;
    private RegistryCreator registryCreator;
    private Printer printer;
    private ExternalComController externalComController;
    private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    private LogHandler logHandler = new LogHandler();

    public Controller(RegistryCreator registryCreator, Printer printer, ExternalComController exernalComController, ErrorMessageHandler errorMsgHandler, LogHandler logHandler) {
        this.registryCreator = registryCreator;
        this.printer = printer;
        this.externalComController = exernalComController;
        this.errorMsgHandler = errorMsgHandler;
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
    public SaleDTO enterItem(int itemID){
        try {
            return saleHandler.addItemToSale(itemID);
        }
        catch (ItemNotFoundException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        catch (DataBaseFailureException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        return saleHandler.getSaleDTO();
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
}
