package book.javavmc.somecontroller;

import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.*;

@Path("/pets")
@Controller
public class PetshopController {
    @Inject
    private Models models;

    @GET
    public String showIndex() {
        final List<Pet> pets = ...;
        models.put("pets", pets);
        return "index.jsp";
    }
}
