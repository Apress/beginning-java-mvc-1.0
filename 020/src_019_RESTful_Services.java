package book.javavmc.restdate;

import java.time.ZonedDateTime;
import javax.ws.rs.*;

/**
 * REST Web Service
 */
@Path("/d")
public class RestDate {
    @GET
    @Path("date")
    @Produces("application/json")
    public String stdDate() {
        return "{\"date\":\"" + 
            ZonedDateTime.now().toString() + 
        "\"}"; 
    }
}
