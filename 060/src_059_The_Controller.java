...
import javax.mvc.binding.MvcBinding;
import javax.mvc.binding.ParamError;
import javax.mvc.binding.BindingResult;
import javax.ws.rs.FormParam;
...

@Path("/controllerPath")
@Controller
public class MyController {

    // Errors while fetching parameters
    // automatically go here:
    private @Inject BindingResult br;

    @POST
    @Path("/response")
    public Response response(
        @MvcBinding @FormParam("name") String name,
        @MvcBinding @FormParam("userId") int userId) {
 
        // ERROR HANDLING //////////////////////////
        if(br.isFailed()) {
          br.getAllErrors().stream().
                forEach((ParamError pe) -> {
            ...
          });
    	}
        // END ERROR HANDLING //////////////////////

        // Handle form input, set model data, ...
    	
        return Response.ok("response.jsp").build();
    }
}
