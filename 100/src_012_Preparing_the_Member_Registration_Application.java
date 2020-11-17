package book.javamvc.jpa.i18n;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Application;

@WebFilter("/*")
public class SetBundleFilter implements Filter {
    @Inject private Application appl; 
    private String i18nAttributeName;
    private String i18nBaseName;
	
    @Override
    public void init(FilterConfig filterConfig) 
          throws ServletException {
      Map<String,Object> applProps = appl.getProperties();
      i18nAttributeName = (String) applProps.get(
          "I18N_TEXT_ATTRIBUTE_NAME");
      i18nBaseName = (String) applProps.get(
          "I18N_TEXT_BASE_NAME");
    }

    @Override
    public void doFilter(ServletRequest request, 
        ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
      BundleForEL.setFor((HttpServletRequest) request,
        i18nAttributeName, i18nBaseName);
      chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
