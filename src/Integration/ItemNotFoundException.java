package Integration;
/**
 * Thrown when the requested itemID does not match the itemIDs
 * in any of the items in the itemRegistry.
 */
public class ItemNotFoundException extends Exception {
    private int itemIDThatCanNotBeFound;
    private String msg;
    /**
     * Creates a new instance representing the condition
     * described in the specified message.
     *
     * @param itemIDThatCanNotBeFound the id of the scanned item that was not found in the itemRegistry
     */
    public ItemNotFoundException(String msg, int itemIDThatCanNotBeFound) {
        super(msg);
        this.msg = msg;
        this.itemIDThatCanNotBeFound = itemIDThatCanNotBeFound;
    }

    public int getitemIDThatCanNotBeFound() {
            return this.itemIDThatCanNotBeFound;
        }
}
