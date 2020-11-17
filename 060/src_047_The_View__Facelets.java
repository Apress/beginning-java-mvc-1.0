package book.javamvc.musicbox.controller;


import java.util.ArrayList;
import java.util.List;

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
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/musicbox")
@Controller
public class MusicBoxController {
    private @Inject BindingResult br;
	
    @GET
    public Response showIndex() {
        return Response.ok("titles.xhtml").build();
    }
    
    @GET
    @Path("/titles")
    public Response showTitles() {
        return Response.ok("titles.xhtml").build();
    }

    @GET
    @Path("/composers")
    public Response showComposers() {
        return Response.ok("composers.xhtml").build();
    }
    
    @GET
    @Path("/performers")
    public Response showPerformers() {
        return Response.ok("performers.xhtml").build();
    }
    
    @POST
    @Path("/response")
    public Response response(
          @MvcBinding @FormParam("name") 
          String name) {
        if(br.isFailed()) {
            // ... handle errors
    	}
    	
        // ... handle user POSTs

        // ... advance to response page
        return Response.ok("response.xhtml").build();
    }
}
