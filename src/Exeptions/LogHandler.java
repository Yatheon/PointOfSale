package Exeptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LogHandler {
    public LogHandler(){

    }

    public void logExeption(Exception exception){
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("**This message is intended for log**\n");
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        System.out.println(logMsgBuilder);

    }
    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
