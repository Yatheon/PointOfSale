package View;

import Controller.Controller;
import Integration.SaleDTO;
import Integration.DataBaseFailureException;
import Exception.ErrorMessageHandler;
import Integration.ItemNotFoundException;
import Exception.LogHandler;
public class View {
    Controller controller;
    SaleDTO saleDTO;
    double change;
    private ErrorMessageHandler errorMsgHandler;
    private LogHandler logHandler;

    public View(Controller controller, ErrorMessageHandler errorMsgHandler, LogHandler logHandler){
        this.controller = controller;
        this.errorMsgHandler = errorMsgHandler;
        this.logHandler = logHandler;
    }
    public void sampleExecution(){


        controller.startSale();
        TotalRevenueView totalRevenueView = new TotalRevenueView();
        controller.addSaleHandlerObserver(totalRevenueView);
        System.out.println("Enter choklad id");
        try {
            saleDTO = controller.enterItem(632);
        }
        catch (ItemNotFoundException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        catch (DataBaseFailureException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }


        System.out.println("Enter bacon id");
        try {
            saleDTO = controller.enterItem(2);
        }
        catch (ItemNotFoundException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        catch (DataBaseFailureException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        System.out.println("Total cost is: "+saleDTO.getTotalCost());
        System.out.println("Payment: 53");

        change = controller.finishSale(53);
        System.out.println("Change: "+change);


        /*Next iterration*/
        controller.startSale();
        controller.addSaleHandlerObserver(totalRevenueView);
        System.out.println("Enter choklad id");
        try {
            saleDTO = controller.enterItem(632);
        }
        catch (ItemNotFoundException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        catch (DataBaseFailureException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }


        System.out.println("Enter bacon id");
        try {
            saleDTO = controller.enterItem(2);
        }
        catch (ItemNotFoundException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        catch (DataBaseFailureException e){
            logHandler.logExeption(e);
            errorMsgHandler.showErrorMsg(e);
        }
        System.out.println("Total cost is: "+saleDTO.getTotalCost());
        System.out.println("Payment: 53");

        change = controller.finishSale(53);
        System.out.println("Change: "+change);



    }

}


