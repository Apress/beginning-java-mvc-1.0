package book.javamvc.helloworld;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.binding.MvcBinding;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
@Controller
public class HelloWorldController {
  @Inject UserData userData;
    
  @GET
  public String showIndex() {
    return "index.jsp";
  }

  @POST
  @Path("/greet")
  public Response greeting(@MvcBinding 
        @FormParam("name") 
        String name) {
    userData.setName(name);
    return Response.ok("greeting.jsp").build();
  }
}
