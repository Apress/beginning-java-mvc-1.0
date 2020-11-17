...
import book.javamvc.validation.FloatRange;
...

@Path("/abc")
@Controller
public class SomeController {
    @MvcBinding @FormParam("theDouble")
    @FloatRange(min=1.0, max=2.0, precision = 0.000001)
    private double theDouble;

    ...
}
