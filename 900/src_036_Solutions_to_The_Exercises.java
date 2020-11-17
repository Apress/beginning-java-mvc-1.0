@POST
@Path("/greet")
public Response greeting(
  @MvcBinding @FormParam("name") 
  String name,
  @MvcBinding @FormParam("age")
  @Min(1)
  int age,
  @MvcBinding @FormParam("rank")
  @FloatRange(min=0.0, max=1.0)
  double rank,
  @Context HttpHeaders httpHeaders
) {
    ...
	userData.setRank(rank);
    ...
}
