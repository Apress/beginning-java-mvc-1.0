    ...
    @POST
    @Path("/xyz")
    public Response someMethod(...) {
        // ERROR HANDLING //////////////////////////
        if(br.isFailed()) {
          br.getAllErrors().stream().
                forEach((ParamError pe) -> {
            errorMessages.addMessage(pe.getParamName() + 
                  ": " + pe.getMessage());
          });
          // advance to error page
          return Response.ok("errorPage.jsp").build();
    	}
        // END ERROR HANDLING //////////////////////
    	
        // handle user input via "p1" and "p2" params
        ...

        // advance to response page
        return Response.ok("responsePage.jsp").build();
    }
    ...
