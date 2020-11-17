  @Controller
  @Path("abc")
  public class MyController {   
    @GET
    public Response myResponse() {
        ...
        // This is a subclass of Cookie:
        NewCookie ck = new NewCookie("theCookieName",
            "cookieValue",
            "the/path",
            "my.domain.com",
            42,
            "Some Comment",
            3600*24*365,
            false);

        return Response.
            ok("responsePage.jsp").
            cookie(ck).
            build();
    }
    ...
  }  
