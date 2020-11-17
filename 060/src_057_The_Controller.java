import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.inject.Inject;

@Path("/controllerPath")
@Controller
public class MyController {
    // The controller is under custody of CDI, so
    // we can inject beans.	
    @Inject private SomeDataClass someModelInstance;

    @GET
    public Response showIndex() {
        // Preparing the model:
        someModelInstance.setVal(42);
        ...

        return Response.ok("index.jsp").build();
    }

    @GET
    @Path("/b")
    public String showSomeOtherPage() {
        // Preparing the model:
        someModelInstance.setVal(43);

        return "page_b.jsp";
    }
}
