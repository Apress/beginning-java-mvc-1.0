...
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
...

@Controller
public class SomeController {
    ...
 
    @GET  // or @POST
    public String someMethod(
        ... query and post parameters...,
        @Context HttpHeaders httpHeaders,
        @Context Request request) 
    {
        ...
    }

    ...
}
