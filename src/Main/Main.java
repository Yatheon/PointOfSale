package Main;

import Integration.RegistryCreator;
import Integration.Printer;
import Integration.ExernalComController;
import View.View;
import Controller.Controller;

public class Main {
    public static void main(String[] args){
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
        ExernalComController exernalComController = new ExernalComController();
        Controller controller = new Controller(registryCreator,printer,exernalComController);
        new View(controller).sampleExecution();
    }
}
