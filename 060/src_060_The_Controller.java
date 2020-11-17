import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.inject.Inject;

@Path("/controllerPath")
@Controller
public class MyController {
    // Errors while fetching parameters
    // automatically go here:
    private @Inject BindingResult br;

    @MvcBinding @FormParam("name") 
    private String name;

    @MvcBinding @FormParam("userId") 
    private int userId;
    
    @POST
    @Path("/response")
    public Response response() { 
        // Handle form input, set model data, ...
    	
        return Response.ok("response.jsp").build();
    }
}
