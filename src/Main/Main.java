package Main;

import Exeptions.ErrorMessageHandler;
import Exeptions.LogHandler;
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
        ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
        LogHandler logHandler = new LogHandler();
        Controller controller = new Controller(registryCreator,printer,exernalComController, errorMsgHandler, logHandler);
        new View(controller).sampleExecution();
    }
}
