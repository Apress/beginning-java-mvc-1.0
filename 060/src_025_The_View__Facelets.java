import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/facelets")
@Controller
public class MyFaceletsController {	
    @GET
    public Response showIndex() {
        return Response.ok("index.xhtml").build();
    }
    ...
}
