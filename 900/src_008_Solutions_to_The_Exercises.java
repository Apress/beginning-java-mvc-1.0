import javax.validation.constraints.Pattern;
...
@POST
@Path("/greet")
public Response greeting(
		@MvcBinding @FormParam("name") 
		@Pattern(regexp = "[A-Za-z]*")
		String name) {
    ...
}
