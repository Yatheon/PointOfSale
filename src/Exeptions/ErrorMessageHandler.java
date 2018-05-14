package Exeptions;
/**
 * Handles the Exception communication with the cashier, lets the cashier know
 * about what went wrong
 */
public class ErrorMessageHandler {
    /**
     * prints out the Error message to the user
     * @param exception the exception that has occurred
     */
    public void showErrorMsg(Exception exception) {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append("**This message is intended for the user interface**\n");
        errorMsgBuilder.append("ERROR: ");
        errorMsgBuilder.append(exception);
        errorMsgBuilder.append("\n**End of user message**\n");
        System.out.println(errorMsgBuilder);

    }
}
