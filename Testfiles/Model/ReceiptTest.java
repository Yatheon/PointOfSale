package Model;

import Integration.RegistryCreator;
import Model.SaleHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private RegistryCreator registryCreator;
    private SaleHandler saleHandler;
    @BeforeEach
    void setUp() {
        registryCreator = new RegistryCreator();
        saleHandler = new SaleHandler(registryCreator);
    }

    @AfterEach
    void tearDown() {
        registryCreator = null;
        saleHandler = null;
    }
    @Test
    void testGetReceiptEmpty() {
        Receipt receipt = saleHandler.createReceipt();
        String[] receiptString = receipt.getReceipt();
        String expResult = "Total Cost: 0.0";
        String result  = receiptString[0];
        assertEquals(expResult,result);
    }
    @Test
    void testGetReceiptOneItem() {
        int itemID = 2;
        saleHandler.addItemToSale(itemID);
        Receipt receipt = saleHandler.createReceipt();
        String[] receiptString = receipt.getReceipt();
        String expResult = "10.0  bacon";
        String result  = receiptString[0];
        assertEquals(expResult,result);
    }
}