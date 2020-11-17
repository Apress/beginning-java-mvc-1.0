  ...
  import javax.enterprise.context.SessionScoped;
  ...
  @Named
  @SessionScoped
  public class UserData {
      ...
  }


  @Controller
  public class SomeController {
      @Inject UserData userData; 
      // <- same object inside a session 
      ...
  }
