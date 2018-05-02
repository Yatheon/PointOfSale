package Controller;

import Integration.ExernalComController;
import Integration.Printer;
import Integration.RegistryCreator;
import Integration.SaleDTO;
import Model.SaleHandler;

public class Controller {
    private SaleHandler saleHandler;
    private RegistryCreator registryCreator;
    private Printer printer;
    private ExernalComController exernalComController;

    public Controller(RegistryCreator registryCreator, Printer printer, ExernalComController exernalComController)
    {
        this.registryCreator = registryCreator;
        this.printer = printer;
        this.exernalComController = exernalComController;
    }
    public void startSale()
    {
        this.saleHandler = new SaleHandler();
    }
    public SaleDTO enterItem(int itemID, int quantity)
    {
       return addItem(itemID, quantity);
    }
    public double finishSale(double paymentAmount)
    {

    }
}
