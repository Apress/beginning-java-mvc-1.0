package book.javamvc.helloworld.event;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.Instant;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.BeforeControllerEvent;

@SessionScoped
public class HelloWorldObserver implements Serializable {
    private long controllerStarted;

    public void update(@Observes BeforeControllerEvent 
          beforeController) {
        controllerStarted = Instant.now().toEpochMilli();
        ...
    }

    public void update(@Observes AfterControllerEvent 
           afterController) {
        long controllerElapseMillis = 
            Instant.now().toEpochMilli()
            - controllerStarted;
        ...
    }
    ...
}
