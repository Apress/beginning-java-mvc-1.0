...
import javax.servlet.http.HttpSession;
import javax.mvc.MvcContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import javax.mvc.binding.BindingResult;
import javax.ws.rs.core.Application;
import javax.enterprise.inject.spi.BeanManager;
...

@Controller
public class SomeController {
    // Access to the session. You can use it to retrieve
    // the session ID, the creation time, the last
    // accessed time, and more.
    @Inject private HttpSession httpSession;

    // Access to the MVC context. This is a context
    // object provided by Java MVC. You can use it to
    // construct URIs given the simple controller name
    // and method name, to retrieve the current
    // request's locale, to look up the base URI, and 
    // more.
    @Inject private MvcContext mvcContext;

    // Access to the current servlet request. You can use
    // it to get various HTTP request related properties,
    // like headers, user information, and many more.
    @Inject private HttpServletRequest httpServletRequest;

    // Access to the servlet context. There you can for
    // example get the URI of a resource file, or an
    // info about the server (container), and more.
    @Inject private ServletContext servletContext;

    // Use this to fetch conversion and validation errors.
    // Parameters (@FormParam or @QueryParam) must have 
    // been marked with @MvcBinding for this error
    // fetching process to work. 
    @Inject private BindingResult bindingResult; 

    // Use this to access the application scope 
    // Application object. You can for example register
    // and retrieve application-wide custom properties. 
    @Inject private Application application;

    // In case you ever need to have programmatic access
    // to CDI, you can inject the BeanManager. This can
    // also be handy for diagnostic purposes.
    @Inject private BeanManager beanManager;


    ...
}
