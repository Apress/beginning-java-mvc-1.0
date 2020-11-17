...
import javax.mvc.Controller;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/abc")
@Controller
public class SomeController {
    // Assuming the JSP is stored at 
    // WEB-INF/views/fragm1.jsp
    @POST
    @Path("/fragm1")
    public Response fragm1(...) {
        ...
        return Response.ok("fragm1.jsp").
              type(MediaType.TEXT_PLAIN).build();
    }
}
