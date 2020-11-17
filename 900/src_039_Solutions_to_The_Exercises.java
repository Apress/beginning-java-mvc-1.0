    @POST
    @Path("/greet")
    public Response greeting(
        ...
	@MvcBinding @FormParam("dateOfBirth")
        String dateOfBirthStr
        ...)
    {
        ...
    	DateTimeFormatter dtf = 
            DateTimeFormatter.
            ofPattern("yyyy-MM-dd");
    	LocalDate ld = LocalDate.parse(
            dateOfBirthStr, dtf);
    	userData.setDateOfBirth(ld);
    	...
    }
