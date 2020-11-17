  import javax.enterprise.context.RequestScoped;
  import javax.inject.Named;

  @Named("user")
  @RequestScoped
  public class UserData {
    private String name;
    private String email;
    // Getters and setters...
  }
