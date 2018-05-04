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
        saleDTO = controller.enterItem(3);
        saleDTO = controller.enterItem(2);
        change = controller.finishSale(53);
        System.out.println("Change: "+change);
        System.out.println("Hello, World");


    }

}
