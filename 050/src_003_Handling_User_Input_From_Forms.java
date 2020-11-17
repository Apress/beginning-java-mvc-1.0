...
import javax.mvc.binding.MvcBinding;
import javax.ws.rs.FormParam;
...

@Path("/abc")
@Controller
public class SomeController {
    @MvcBinding @FormParam("p1")
    private String p1;

    @MvcBinding @FormParam("p2")
    private String p2;

    ...
    
    @POST
    @Path("/xyz")
    public Response someMethod() {
        // handle user input via "p1" and "p2" fields
        ...
        return Response.ok("responsePage.jsp").build();
    }
}
