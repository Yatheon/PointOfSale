package Controller;

import Integration.*;
import Model.SaleHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private RegistryCreator registryCreator;
    private Printer printer;
    private ExernalComController externalComController;
    private Controller controller;
    private ItemRegistry itemRegistry;
    private SaleHandler saleHandler;
    @BeforeEach
    void setUp() {
        registryCreator = new RegistryCreator();
        externalComController = new ExernalComController();
        printer = new Printer();
        controller = new Controller(registryCreator,printer,externalComController);
        itemRegistry = new ItemRegistry();
        saleHandler = new SaleHandler(registryCreator);
        controller.startSale();
    }

    @AfterEach
    void tearDown() {
        registryCreator = null;
        externalComController = null;
        printer = null;
        controller = null;
        itemRegistry = null;
        saleHandler = null;
    }


    @Test
    void testEnterItem() {
        int testItemID = 2;
        SaleDTO result = controller.enterItem(testItemID);
        ItemDTO[] itemList = {itemRegistry.getItem(2)};
        SaleDTO expResult = new SaleDTO(itemList,10,4);


        assertEquals(expResult.getTotalCost(),result.getTotalCost());
        assertEquals(expResult.getItemDTO()[0].getName(),result.getItemDTO()[0].getName());

    }

    @Test
    void testFinishSale1() {
        double result = controller.finishSale(100);
        double expResult = 100;

        assertEquals(expResult,result);
    }
    @Test
    void testFinishSale2() {
        controller.enterItem(2);
        double result = controller.finishSale(100);
        double expResult = 100-10;

        assertEquals(expResult,result);
    }
}