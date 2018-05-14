package Exeptions;

public class ErrorMessageHandler {
    void showErrorMsg(String msg) {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append("**This message is intended for the user interface**\n");
        errorMsgBuilder.append("ERROR: ");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }
}
