import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/controllerPath")
@Controller
public class MyController {	
    @GET
    public Response showIndex() {
        return Response.ok("index.jsp").build();
    }

    @GET
    @Path("/b")
    public String showSomeOtherPage() {
        return "page_b.jsp";
    }
}
