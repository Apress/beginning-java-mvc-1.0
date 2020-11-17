  public class SomeController {

    // constraints for fields: 

    @MvcBinding @FormParam("name")
    @CONSTRAINT1 
    @CONSTRAINT2
    ...
    private String formParam; // or other type

    // or, for query parameters:

    @MvcBinding @QueryParam("name")
    @CONSTRAINT1 
    @CONSTRAINT2
    ...
    private String queryParam; // or other type

    // or, in controller action:

    @POST
    @Path("/xyz")
    public Response someMethod(
        @MvcBinding @FormParam("name")
        @CONSTRAINT1
        @CONSTRAINT2
        ... 
        String name )
    {
        ...
    }

    // or, for query parameters:

    @GET
    @Path("/xyz")
    public Response someMethod(
        @MvcBinding @QueryParam("name")
        @CONSTRAINT1
        @CONSTRAINT2
        ... 
        String name )
    {
        ...
    }
  }
