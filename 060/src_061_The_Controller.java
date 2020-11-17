...
import javax.mvc.binding.MvcBinding;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
@Controller
public class SomeController {
    private @Inject BindingResult br;

    @GET
    @Path("/start")
    public String someMethod(
        @MvcBinding @QueryParam("name") String name,
        @MvcBinding @QueryParam("birthday") String birthday) {
      if(name != null) {
        // handle "name" parameter
      }
      if(birthday != null) {
        // handle "birthday" parameter
      }

      // advance to page
      return "index.jsp";
    }
    ...
}
