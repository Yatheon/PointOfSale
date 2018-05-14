package Exeptions;
/**
 * Thrown when the requested itemID does not match the itemIDs
 * in any of the items in the itemRegistry.
 */
public class ItemNotFoundExeption extends Exception {
    private int itemIDThatCanNotBeFound;
    /**
     * Creates a new instance representing the condition
     * described in the specified message.
     *
     * @param itemIDThatCanNotBeFound the id of the scanned item that was not found in the itemRegistry
     */
    public ItemNotFoundExeption( int itemIDThatCanNotBeFound) {
        this.itemIDThatCanNotBeFound = itemIDThatCanNotBeFound;
    }
    public String toString(){
        return "Error: An item with this ID can not be found: "+itemIDThatCanNotBeFound;
    }
    public int getitemIDThatCanNotBeFound() {
            return this.itemIDThatCanNotBeFound;
        }


}
