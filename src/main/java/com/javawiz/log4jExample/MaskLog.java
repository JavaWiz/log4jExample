package com.javawiz.log4jExample;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
/*

* converting/overriding key “%m” in this class.

* Now message will be masked before writing to the actual log

* please refer PatternLayout in log4j2.xml to see how %m is used

*/

@Plugin(name ="logmask", category ="Converter")
@ConverterKeys({"m"})

public class MaskLog extends LogEventPatternConverter {
     public MaskLog (String[] options) {
           super("m","m");
     }

     public static MaskLog newInstance(final String[] options) {
          return new MaskLog (options);
     }

/*
* this method is responsible for actually masking the log
*/

     @Override
     public void  format(LogEvent logEvent, StringBuilder outputMsg) {
          String message = logEvent.getMessage().getFormat();
          String REGEX_CREDIT_CARD = "([0-9]{6})[0-9]{0,9}([0-9]{4})";
          outputMsg.append(message.replaceAll(REGEX_CREDIT_CARD, "XXXX XXXX XXXX XXXX"));
     }
}