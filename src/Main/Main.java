package Main;

import Exceptions.ErrorMessageHandler;
import Exceptions.LogHandler;
import Integration.RegistryCreator;
import Integration.Printer;
import Integration.ExternalComController;
import View.View;
import Controller.Controller;

public class Main {
    public static void main(String[] args){
        RegistryCreator registryCreator = new RegistryCreator();
        Printer printer = new Printer();
        ExternalComController exernalComController = new ExternalComController();
        ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
        LogHandler logHandler = new LogHandler();
        Controller controller = new Controller(registryCreator,printer,exernalComController, errorMsgHandler, logHandler);
        new View(controller).sampleExecution();
    }
}
