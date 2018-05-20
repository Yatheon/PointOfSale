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
        controller.addObserver(new TotalRevenueView());
        this.errorMsgHandler = errorMsgHandler;
        this.logHandler = logHandler;
    }
    public void sampleExecution(){


        controller.startSale();
        System.out.println("----------Session one------------\n");
        System.out.println("Enter choklad id");
        try {
            saleDTO = controller.enterItem(632);
        }
        catch (ItemNotFoundException e){
            errorMsgHandler.showErrorMsg(e);
        }



        System.out.println("Enter bacon id");
        try {
            saleDTO = controller.enterItem(2);
        }
        catch (ItemNotFoundException e){
            errorMsgHandler.showErrorMsg(e);
        }

        System.out.println("Total cost is: "+saleDTO.getTotalCost());
        System.out.println("Payment: 53");

        change = controller.finishSale(53);
        System.out.println("Change: "+change);
        System.out.println("----------------------\n");

        /*----------------*/

        /*---------Next session----------*/
        System.out.println("----------Session two------------\n");
        controller.startSale();
        System.out.println("Enter choklad id");
        try {
            saleDTO = controller.enterItem(666);
        }
        catch (ItemNotFoundException e){
            errorMsgHandler.showErrorMsg(e);
        }

        System.out.println("Enter bacon id");
        try {
            saleDTO = controller.enterItem(2);
        }
        catch (ItemNotFoundException e){
            errorMsgHandler.showErrorMsg(e);
        }

        System.out.println("Total cost is: "+saleDTO.getTotalCost());
        System.out.println("Payment: 53");

        change = controller.finishSale(53);
        System.out.println("Change: "+change);
        System.out.println("----------------------\n");



    }

}


