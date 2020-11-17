   @POST
   @Path("/response")
   public Response response(
       @MvcBinding @FormParam("name") String name,
       @MvcBinding @FormParam("userId") int userId) {

       // Handle form input, set model data, ...
   	
       return Response.ok("response.jsp").build();
   }
