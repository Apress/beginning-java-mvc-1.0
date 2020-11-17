package book.javamvc.helloworld;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mvc.Controller;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.MvcBinding;
import javax.mvc.binding.ParamError;
import javax.validation.constraints.*;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/hello")
@Controller
public class HelloWorldController {
  @Named
  @RequestScoped
  public static class ErrorMessages {
    private List<String> msgs = new ArrayList<>();
		
    public List<String> getMsgs() {
      return msgs;
    }

    public void setMsgs(List<String> msgs) {
      this.msgs = msgs;
    }

    public void addMessage(String msg) {
      msgs.add(msg);
    }
  }

  private @Inject ErrorMessages errorMessages;	
  private @Inject BindingResult br;
  ...
    
  @POST
  @Path("/greet")
  public Response greeting(
      @MvcBinding @FormParam("name") 
      String name) 
  {
    if(br.isFailed()) {
      br.getAllErrors().stream().forEach(
        (ParamError pe) -> {
        errorMessages.addMessage(pe.getParamName() + 
        ": " + pe.getMessage());
      });
    }
    	
    ...
  }
}
