package Model;

import Integration.ItemDTO;
import Integration.ItemRegistry;
import Integration.RegistryCreator;
import Integration.SaleDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleHandlerTest extends Object {
    private RegistryCreator registryCreator;
    private SaleHandler saleHandler;

    @BeforeEach
    void setUp() {
        registryCreator = new RegistryCreator();
        saleHandler = new SaleHandler(registryCreator.getItemRegistry());
    }

    @AfterEach
    void tearDown() {
        registryCreator = null;
        saleHandler = null;
    }

    @Test
    void testAddItemToSale() {
        int testVariable = 2;
        double expResult = 10;
        SaleDTO saleDTO = saleHandler.addItemToSale(testVariable);
        double result = saleDTO.getTotalCost();
        assertEquals(expResult,result);
    }

    @Test
    void testCalculateChangeEmptyList() {
        int testVariable = 10;
        double expResult = 10;
        double result = saleHandler.calculateChange(testVariable);
        assertEquals(expResult,result);
    }

    @Test
    void testCalculateChangeOneItemList() {
        int itemID = 2;
        int testVariable = 10;
        saleHandler.addItemToSale(itemID);
        double expResult = 0;
        double result = saleHandler.calculateChange(testVariable);
        assertEquals(expResult,result);
    }

}