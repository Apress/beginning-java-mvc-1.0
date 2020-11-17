package book.javamvc.helloworld;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/mvc")
public class App extends Application {
    private final static Logger LOG = 
      Logger.getLogger(App.class.toString());
	
    @PostConstruct
    public void init() {
      LOG.entering(this.getClass().toString(), 
          "init");
    }

	
    @Override 
    public Map<String, Object> getProperties() {
      LOG.entering(this.getClass().toString(), 
        "getProperties");
      Map<String, Object> res = new HashMap<>();
      res.put("I18N_TEXT_ATTRIBUTE_NAME", 
        "msg");
      res.put("I18N_TEXT_BASE_NAME", 
        "book.javamvc.helloworld.messages.Messages");
      LOG.info("Set 'I18N_TEXT_ATTRIBUTE_NAME' to "+
        "'msg'");
      LOG.info("Set 'I18N_TEXT_BASE_NAME' to " + 
        "'book.javamvc.helloworld.messages." + 
        "Messages'");
      return res;
    }
}
