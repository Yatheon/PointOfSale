package Model;

import Integration.RegistryCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleHandlerTest extends Object {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addItemToSale() {
    }

    @Test
    void calculateChange() {
        RegistryCreator registryCreator = new RegistryCreator();
        SaleHandler saleHandler = new SaleHandler(registryCreator);

    }

    @Test
    void getSaleDTO() {
    }

    @Test
    void createReceipt() {
    }

}