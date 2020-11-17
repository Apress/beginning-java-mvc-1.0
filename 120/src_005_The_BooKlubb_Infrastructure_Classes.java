package book.javamvc.bk;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/mvc")
public class App extends Application {
  @PostConstruct
  public void init() {
  }
	
  @Override 
  public Map<String, Object> getProperties() {
    Map<String, Object> res = new HashMap<>();
    res.put("I18N_TEXT_ATTRIBUTE_NAME", 
      "msg");
    res.put("I18N_TEXT_BASE_NAME", 
      "book.javamvc.bk.messages.Messages");
    return res;
  }
}
