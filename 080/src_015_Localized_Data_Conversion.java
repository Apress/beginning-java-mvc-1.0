   @POST
   @Path("/response")
   public Response response(
       @MvcBinding @FormParam("name") String name,
       @MvcBinding @FormParam("userId") int userId) {
       @MvcBinding @FormParam("rs") long timeStamp,
       @MvcBinding @FormParam("rank") double rank) {

       // Handle form input, set model data, ...,
       // return response
   }
