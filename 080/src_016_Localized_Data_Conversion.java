    @POST
    @Path("/response")
    public Response response(
        @MvcBinding @FormParam("day") String day,
        @Context HttpHeaders httpHeaders) {
 
        Locale loc = httpHeaders.getLanguage();
        // <- You could use this for locale specific
        // conversion rules.

        DateTimeFormatter formatter1 = 
          DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(day, 
          formatter1);


        ...
    }
