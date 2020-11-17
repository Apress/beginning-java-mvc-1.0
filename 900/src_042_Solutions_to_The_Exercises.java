package book.javamvc.simplenojee;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateTime {
  public String date(String format) {
    ZonedDateTime zdt = ZonedDateTime.now();
    String outStr = "";
    try {
      outStr = (format == null || "".equals(format) ? 
          zdt.toString() : 
          zdt.format(DateTimeFormatter.
              ofPattern(format)));
    } catch(Exception e) {
      e.printStackTrace(System.err);
    }
    return outStr;
  }
}
