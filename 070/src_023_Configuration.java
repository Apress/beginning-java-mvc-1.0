package any.project.package;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.mvc.engine.ViewEngine;
import javax.mvc.security.Csrf;
...

@ApplicationPath("/mvc")
public class App extends Application {
    @Override 
    public Map<String,Object>getProperties(){ 
      final Map<String,Object> map = new HashMap<>();

      // This setting makes sure view files
      // will be looked up at some specified location
      // (default is /WEB-INF/views) 
      map.put(ViewEngine.VIEW_FOLDER,"/jsp/"); 

      // Set a CSRF (cross site request forgery)
      // security mode. See chapter 4 of the
      // specification
      map.put(Csrf.CSRF_PROTECTION,
          Csrf.CsrfOptions.OFF);  // default
      // ...or...
      map.put(Csrf.CSRF_PROTECTION,
          Csrf.CsrfOptions.EXPLICIT); 
      // ...or...
      map.put(Csrf.CSRF_PROTECTION,
          Csrf.CsrfOptions.IMPLICIT); 

      // Set CSRF header name. See chapter 4 of the
      // specification. Default is "X-CSRF-TOKEN".
      map.put(Csrf.CSRF_HEADER_NAME,
          "CSRF-HDR");

      return map; 
    }
}
