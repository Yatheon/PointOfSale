package Integration;

import Model.Receipt;

/**
 * Prints out the receipt of a finished sale
 */
public class Printer {
    public Printer(){}
    public void printReceipt(Receipt receipt){
        String[] receiptPrint = receipt.getReceipt();
        System.out.println("\n*Printing receipt*");
        System.out.println("--Receipt--");
        for(int i= 0; i < receiptPrint.length; i++)
        System.out.println(receiptPrint[i]);
        System.out.println("--Receipt--\n");
    }
}
