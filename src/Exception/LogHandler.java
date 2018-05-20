package Exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
/**
 * Hypothetically: Creates a log file about a error that a administrator can examine
 * Actually: Prints out detailed information about a system error
 *
 */
public class LogHandler {
    public LogHandler(){
    }
    /**
     * prints out the Error message for the administrator
     * @param exception the exception that has occurred
     */
    public void logExeption(Exception exception){
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("**This message is intended for log**\n");
        logMsgBuilder.append(createTime()+"\n");
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception);
        logMsgBuilder.append("\n**End of log message**\n");
        System.out.println(logMsgBuilder);

    }
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
