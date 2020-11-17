package book.javamvc.jpa;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import book.javamvc.jpa.db.MemberDAO;

@Path("/ajax")
public class AjaxController {
  @EJB private MemberDAO memberDao;
    
  @DELETE
  @Path("/delete/{id}")
  public Response delete(@PathParam("id") int id) {
      memberDao.deleteMember(id);
      return Response.ok("{}").build();
  }
}
