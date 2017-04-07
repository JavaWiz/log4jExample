package com.javawiz.log4jExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class CardNumberFilteringLayout extends PatternLayout {
    private static final String MASK = "$1-XXXX-XXXX-$2";
    private static final Pattern PATTERN = Pattern.compile("\\b([0-9]{4})[0-9]{0,8}([0-9]{4})\\b");

    @Override
    public String format(LoggingEvent event) {
        if (event.getMessage() instanceof String) {
            String message = event.getRenderedMessage();
            Matcher matcher = PATTERN.matcher(message);
            if (matcher.find()) {
                String maskedMessage = matcher.replaceAll(MASK);
                Throwable throwable = event.getThrowableInformation() != null ? 
                        event.getThrowableInformation().getThrowable() : null;
                LoggingEvent maskedEvent = new LoggingEvent(event.fqnOfCategoryClass,
                        Logger.getLogger(event.getLoggerName()), event.timeStamp, 
                        event.getLevel(), maskedMessage, throwable);
                return super.format(maskedEvent);
            }
        }
        return super.format(event);
    }
}