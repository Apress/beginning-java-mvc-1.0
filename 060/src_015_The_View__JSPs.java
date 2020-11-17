    // probably inside a models package:
    @Named
    @RequestScoped
    public class Members {
      private List<Member> list = new ArrayList<>();
      public void add(Member member) {
         list.add(member);
      }
      // Getters, setters...
    }

    public class Member {
      private int id;
      private String firstName;
      private String lastName;
      // Constructors, getters, setters...
    }

    // probably inside a controllers package:
´   @Controller
    public class MyController {
        @Inject private Members members; 

        // inside a method:
        members.add(new Member(...));
        members.add(new Member(...));
        ...
    }
