  public class SomeController {
      ...
      @EJB
      private SomeEjbInterface theEjb;

      // or, for no-interface EJBs
      @EJB
      private SomeEjbClass theEjb;
      ...
  }
