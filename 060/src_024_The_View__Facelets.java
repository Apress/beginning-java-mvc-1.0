package any.project.package;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/")
public class RootRedirector extends HttpFilter {
  private static final long serialVersionUID = 
        7332909156163673868L;

  @Override
  protected void doFilter(final HttpServletRequest req, 
        final HttpServletResponse res,  
        final FilterChain chain) throws   IOException {
      res.sendRedirect("mvc/facelets");
  }
}
