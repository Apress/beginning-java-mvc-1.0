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
          @MvcBinding @FormParam("p1") String p1,
          @MvcBinding @FormParam("p2") String p2,
          ...more parameters...
    ) {
        // handle user input ...
        ...
        return Response.ok("responsePage.jsp").build();
    }
}
