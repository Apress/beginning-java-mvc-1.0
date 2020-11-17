@GET
public String showIndex(
   @MvcBinding @QueryParam("name") 
   String name) 
{
  if(name != null) {
    models.put("name", name);
  }
  return "index.jsp";
}
