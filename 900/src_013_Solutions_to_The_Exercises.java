...
@Controller
public class HelloWorldController {

  private @Inject UserData userData;
  //private @Inject Models models; REMOVE THIS

  ...
    
  @GET
  public String showIndex(@MvcBinding 
        @QueryParam("name") String name) {
    if(name != null) {
      userData.setName(name);
    }
    return "index.jsp";
  }

  @POST
  @Path("/greet")
  public Response greeting(
    @MvcBinding @FormParam("name") 
    @Pattern(regexp = "[A-Za-z]*")
    String name) 
  {
    ...

    userData.setName(name);
    return Response.ok("greeting.jsp").build();
  }
}
