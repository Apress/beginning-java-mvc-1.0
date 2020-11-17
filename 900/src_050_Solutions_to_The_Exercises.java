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
import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import book.javamvc.jpa.data.User;
import book.javamvc.jpa.db.MemberDAO;
import book.javamvc.jpa.db.Status;
import book.javamvc.jpa.model.UserEntering;
import book.javamvc.jpa.model.UserList;

@Path("/hello")
@Controller
public class HelloJpaController {
    ...
    @POST
    @Path("/add")
    public Response addMember(
        @MvcBinding @FormParam("name") 
          String name,
        @MvcBinding @FormParam("statusLst") 
        @Pattern(regexp = "(\\w*(,\\s*\\w*)*)?")
          String statusLst) {
    	if(br.isFailed()) {
          br.getAllErrors().stream().forEach(
            (ParamError pe) -> {
            errorMessages.addMessage(
              pe.getParamName() + ": " + 
              pe.getMessage());
          });
    	} else {
          userEntering.setName(name); 
          userEntering.setStatusLst(statusLst);
          memberDao.addMember(name, statusLst);
    	}
    	
        addUserList();
        return Response.ok("index.jsp").build();
    }
    ...    
    
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////
    
    private void addUserList() {
      userList.addAll(
        memberDao.allMembers().stream().
            map(member -> { 
          int id = member.getId();
          String name = member.getName();
          String statusLst = member.getStatus().
              stream().
              map( Status::getName ).
              collect(Collectors.joining(", "));
          return new User(id, name, statusLst);
      }).collect(Collectors.toList()) );
    }
}
