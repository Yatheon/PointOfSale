package View;

import Controller.Controller;
import Integration.SaleDTO;

public class View {
    Controller controller;
    SaleDTO saleDTO;
    double change;

    public View(Controller controller){
        this.controller = controller;
    }
    public void sampleExecution(){


        controller.startSale();
        System.out.println("Enter choklad id");
        saleDTO = controller.enterItem(666);
        System.out.println("Enter bacon id");
        saleDTO = controller.enterItem(0);
        System.out.println("Total cost is: "+saleDTO.getTotalCost());
        System.out.println("Payment: 53");

        change = controller.finishSale(53);
        System.out.println("Change: "+change);



    }

}
