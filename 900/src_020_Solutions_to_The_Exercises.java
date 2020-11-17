package book.javamvc.helloworld;

import javax.servlet.http.HttpSession;
...

@Path("/hello")
@Controller
public class HelloWorldController {
    ...
    private @Inject HttpSession httpSession;	
    ...
    @GET
    public String showIndex() {
        System.err.println("Session ID: " + 
              httpSession.getId());
        ...
    }
    ...
}
