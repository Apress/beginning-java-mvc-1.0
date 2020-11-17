package book.javamvc.jpa;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Redirecting http://localhost:8080/HelloJpa/
 * This way we don't need a <welcome-file-list> in web.xml
 */
@WebFilter(urlPatterns = "/")
public class RootRedirector extends HttpFilter {
    private static final long serialVersionUID = 
          7332909156163673868L;

    @Override
    protected void doFilter(final HttpServletRequest req, 
          final HttpServletResponse res, 
          final FilterChain chain) throws IOException {
        res.sendRedirect("mvc/hello");
    }
} 
