...
import book.javamvc.validation.StringEnum;
...

@Path("/abc")
@Controller
public class SomeController {
    @MvcBinding @FormParam("fruit")
    @StringEnum({"grape", "apple", "banana"})
    private String fruit;

    ...
}
