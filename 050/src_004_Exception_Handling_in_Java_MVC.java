...
import javax.mvc.binding.MvcBinding;
import javax.mvc.binding.BindingResult;
import javax.ws.rs.FormParam;
import javax.validation.constraints.Size;
...

@Path("/abc")
@Controller
public class SomeController {
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

    // Errors while fetching parameters
    // automatically go here:
    private @Inject BindingResult br;

    // We use this to pass over error messages
    // to the response page:
    private @Inject ErrorMessages errorMessages;

    ...
    
    @POST
    @Path("/xyz")
    public Response someMethod(
          @MvcBinding @FormParam("p1")
          @Size(min=3,max=10)
              String p1,
          @MvcBinding @FormParam("p2")
              String p2) 
    {
        // ERROR HANDLING //////////////////////////
        if(br.isFailed()) {
          br.getAllErrors().stream().
                forEach((ParamError pe) -> {
            errorMessages.addMessage(pe.getParamName() + 
                  ": " + pe.getMessage());
          });
        }
        // END ERROR HANDLING //////////////////////
    	
        // handle user input via "p1" and "p2" params
        ...

        // advance to response page
        return Response.ok("responsePage.jsp").build();
    }
}
