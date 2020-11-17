package book.javamvc.helloworld.event;

import java.io.Serializable;
import java.time.Instant;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.BeforeControllerEvent;

@SessionScoped
public class HelloWorldObserver 
      implements Serializable {
    private static final long serialVersionUID = 
        -2547124317706157382L;
	
    private long controllerStarted;

    public void update(@Observes 
        BeforeControllerEvent 
        beforeController) {
      controllerStarted = Instant.now().
          toEpochMilli();
    }

    public void update(@Observes 
        AfterControllerEvent 
        afterController) {
      long controllerElapseMillis = 
          Instant.now().toEpochMilli() -
          controllerStarted;
		
      System.err.println("Elapse = " + 
          controllerElapseMillis + "ms");
    }
}
