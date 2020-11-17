@POST
@Path("/ageAjax")
public Response ageAjax(
      @MvcBinding @FormParam("age") 
      int age) {
    if(br.isFailed()) {
        br.getAllErrors().stream().
        forEach((ParamError pe) -> {
          errorMessages.addMessage(
              pe.getParamName() 
              + ": " + pe.getMessage());
      });
    }
    userData.setAge(age);
    return Response.ok("ageAjaxFragm.jsp").
        type(MediaType.APPLICATION_JSON).
        build();
}
