// App.java:
package book.javamvc.helloworld;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/mvc")
public class App extends Application {
}


// RootRedirector.java
package book.javamvc.helloworld;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Redirecting http://localhost:8080/HelloWorld/
 * This way we don't need a <welcome-file-list> in web.xml
 */
@WebFilter(urlPatterns = "/")
public class RootRedirector extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, 
          HttpServletResponse res, 
          FilterChain chain) throws IOException {
        res.sendRedirect("mvc/hello");
    }
}


// HelloWorldController.java
package book.javamvc.helloworld;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.binding.MvcBinding;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
@Controller
public class HelloWorldController {
    @Inject
    private Models models;
    
    @GET
    public String showIndex() {
        return "index.jsp";
    }

    @POST
    @Path("/greet")
    public Response greeting(@MvcBinding @FormParam("name") 
          String name) {
        models.put("name", name);
        return Response.ok("greeting.jsp").build();
    }
}
