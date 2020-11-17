  @Controller
  @Path("/xyz")
  public class SomeController {
    @Inject BindingResult br;

    @MvcBinding @FormParam("name")
    @Size(min=3,max=10) 
    private String formParam;

    ...
  }
