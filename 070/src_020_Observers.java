package book.javamvc.helloworld.event;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.AfterProcessViewEvent;
import javax.mvc.event.BeforeControllerEvent;
import javax.mvc.event.BeforeProcessViewEvent;
import javax.mvc.event.ControllerRedirectEvent;

@SessionScoped
public class HelloWorldObserver implements Serializable {
  private static final long serialVersionUID = 
        -2547124317706157382L;

  public void update(@Observes BeforeControllerEvent 
        beforeController) {
    Class<?> clazz = beforeController.getResourceInfo().
        getResourceClass();
    Method m = beforeController.getResourceInfo().
        getResourceMethod();
    System.err.println(this.toString() + ": " + 
        clazz + " - " + m);
  }

  public void update(@Observes AfterControllerEvent 
        afterController) {
    System.err.println(this.toString() + ": " + 
        afterController);
  }

  public void update(@Observes ControllerRedirectEvent 
        controllerRedirect) {
    System.err.println(this.toString() + ": " + 
        controllerRedirect);
  }

  public void update(@Observes BeforeProcessViewEvent 
        beforeProcessView) {
    String view = beforeProcessView.getView();
    System.err.println(this.toString() + ": " + 
        view);
  }

  public void update(@Observes AfterProcessViewEvent 
        afterProcessView) {
    System.err.println(this.toString() + ": " +  
        afterProcessView);
  }
}
