import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
...

@Path("/abc")
@Controller
public class SomeController {
    @Inject private Models models;

    ...
    // inside any method:    
    models.put("name", name);
    ...
}
