package book.javamvc.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mvc.Controller;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.MvcBinding;
import javax.mvc.binding.ParamError;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import book.javamvc.jpa.data.User;
import book.javamvc.jpa.db.MemberDAO;
import book.javamvc.jpa.model.UserEntering;
import book.javamvc.jpa.model.UserList;

@Path("/hello")
@Controller
public class HelloJpaController {
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

  @Inject private ErrorMessages errorMessages;
  @Inject private BindingResult br;
	
  @Inject private UserEntering userEntering;
  @Inject private UserList userList;
	
  @EJB private MemberDAO memberDao;

  @GET
  public String showIndex() {
    addUserList();
    return "index.jsp";
  }

  @POST
  @Path("/add")
  public Response addMember(
        @MvcBinding @FormParam("name") String name) {
    if(br.isFailed()) {
      br.getAllErrors().stream().
            forEach((ParamError pe) -> {
        errorMessages.addMessage(pe.getParamName() + 
              ": " + pe.getMessage());
      });
    }
    	
    userEntering.setName(name); 
    	
    memberDao.addMember(userEntering.getName());
    	
    addUserList();
    return Response.ok("index.jsp").build();
  }
        
  ////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////
    
  private void addUserList() {
    userList.addAll(
      memberDao.allMembers().stream().map(member -> { 
          return new User(member.getId(), 
                          member.getName());
      }).collect(Collectors.toList())
    );
  }  
}
