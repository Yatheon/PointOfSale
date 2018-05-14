package Exeptions;
/**
 * Thrown when something goes wrong internally with the database
 */
public class DataBaseFailureExeption extends Exception {
    private int itemIDThatCanNotBeFound;
    /**
     * Creates a new instance representing the condition
     * described in the specified message.
     *
     * @param itemIDThatCanNotBeFound the id of the scanned item that caused the database failure when
     *                                searched for.
     */
    public DataBaseFailureExeption( int itemIDThatCanNotBeFound) {
        this.itemIDThatCanNotBeFound = itemIDThatCanNotBeFound;
    }
    public String toString(){
        return "Something went wrong when searching for this item: "+this.itemIDThatCanNotBeFound+
                "\nPlease notify a administrator about this.";
    }
    public int getitemIDThatCanNotBeFound() {
        return this.itemIDThatCanNotBeFound;
    }
}
