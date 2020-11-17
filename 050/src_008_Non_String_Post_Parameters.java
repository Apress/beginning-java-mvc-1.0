...
import javax.mvc.binding.MvcBinding;
import javax.ws.rs.FormParam;
...

@Path("/abc")
@Controller
public class SomeController {
    ...
    
    @POST
    @Path("/xyz")
    public Response someMethod(
        @MvcBinding @FormParam("theInt")
            int theInt,
        @MvcBinding @FormParam("theDouble")
            double theDouble,
        @MvcBinding @FormParam("theBoolean")
            boolean theBoolean) 
    {
        // handle user input via the fields
        ...
        return Response.ok("responsePage.jsp").build();
    }
}
