package Integration;

import Model.Receipt;

/**
 * Prints out the receipt of a finished sale
 */
public class Printer {
    public Printer(){}
    public void printReceipt(Receipt receipt){
        String[] receiptPrint = receipt.getReceipt();
        for(int i= 0; i < receiptPrint.length; i++)
        System.out.println(receiptPrint[i]);

    }
}
