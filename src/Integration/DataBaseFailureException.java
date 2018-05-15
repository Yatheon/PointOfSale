package Integration;
/**
 * Thrown when something goes wrong internally with the database
 */
public class DataBaseFailureException extends Exception {
    private int itemIDThatCanNotBeFound;
    private String msg;
    /**
     * Creates a new instance representing the condition
     * described in the specified message.
     *
     * @param itemIDThatCanNotBeFound the id of the scanned item that caused the database failure when
     *                                searched for.
     */
    public DataBaseFailureException(String msg, int itemIDThatCanNotBeFound) {
        super(msg);
        this.msg = msg;
        this.itemIDThatCanNotBeFound = itemIDThatCanNotBeFound;
    }

    public int getitemIDThatCanNotBeFound() {
        return this.itemIDThatCanNotBeFound;
    }
}
