  ...
  import javax.validation.constraints.Min;
  ...
  @Path("/hello")
  @Controller
  public class HelloWorldController {
    @Named
    @RequestScoped
    public static class ErrorMessages {
      private List<String> msgs = new ArrayList<>();	
      public List<String> getMsgs() {
        return msgs;
      }
      public void setMsgs(List<String> msgs) {
        this.msgs = msgs;
      }
      public void addMessage(String msg) {
        msgs.add(msg);
      }
    }

    private @Inject UserData userData;
    private @Inject ErrorMessages errorMessages;
    private @Inject BindingResult br;
    ...

    @POST
    @Path("/greet")
    public Response greeting(
          @MvcBinding @FormParam("name") 
          String name,
          @MvcBinding @FormParam("age")
          @Min(1)
          int age) {
      if(br.isFailed()) {
        br.getAllErrors().stream().forEach(
              (ParamError pe) -> {
                errorMessages.addMessage(
                    pe.getParamName() + ": " + 
                    pe.getMessage());
          });
      }
      userData.setName(name);
      userData.setAge(age);
      return Response.ok("greeting.jsp").build();
    }
  }
