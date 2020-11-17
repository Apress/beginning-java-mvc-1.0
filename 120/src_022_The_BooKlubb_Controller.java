package book.javamvc.bk;

import ...;

@Path("/bk")
@Controller
public class BooKlubbController {
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

  private @Inject ErrorMessages errorMessages;
  private @Inject BindingResult br;
	 
  private @EJB MemberDAO memberDao;
  private @Inject MemberSearchResult memberSearchResult;

  private @EJB BookDAO bookDao;
  private @Inject BookSearchResult bookSearchResult;

  private @EJB RentalDAO rentalDao;

  private @Inject CurrentMember currentMember;	

  // action methods...		  
}
