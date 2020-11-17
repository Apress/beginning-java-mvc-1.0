    import javax.ws.rs.core.HttpHeaders;
    import javax.ws.rs.core.Context;
    ...

    @POST
    @Path("/greet")
    public Response greeting(
          ...form parameters...,
          @Context HttpHeaders httpHeaders) 
    {
        System.err.println("Headers: \n" + 
    	  httpHeaders.getRequestHeaders().entrySet().
            stream().map( me -> {
    		return me.getKey() + ": " + 
                       me.getValue();
    	  }).collect(Collectors.joining("\n")));
        ...
    }
