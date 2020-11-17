package book.javamvc.i18n;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class BundleForEL extends ResourceBundle {
    // This is the variable name used in JSPs
    private static final String TEXT_ATTRIBUTE_NAME = 
        "msg";

    // This is the base name (including package) of
    // the properties files:
    // TEXT_BASE_NAME + ".properties"       -> default
    // TEXT_BASE_NAME + "_en.properties"    -> English
    // TEXT_BASE_NAME + "_en_US.properties"
    // TEXT_BASE_NAME + "_fr.properties"    -> Fench
    // ...
    private static final String TEXT_BASE_NAME = 
        "book.javamvc.helloworld.messages.Messages";

    private BundleForEL(Locale locale) {
        setLocale(locale);
    }

    public static void setFor(
          HttpServletRequest request) {
        if (request.getSession().
              getAttribute(TEXT_ATTRIBUTE_NAME) == null) {
            request.getSession().
                  setAttribute(TEXT_ATTRIBUTE_NAME, 
                     new BundleForEL(request.getLocale()));
        }
    }

    public static BundleForEL getCurrentInstance(
          HttpServletRequest request) {
        return (BundleForEL) request.getSession().
            getAttribute(TEXT_ATTRIBUTE_NAME);
    }

    public void setLocale(Locale locale) {
        if (parent == null || 
              !parent.getLocale().equals(locale)) {
            setParent(getBundle(TEXT_BASE_NAME, locale));
        }
    }    

    @Override
    public Enumeration<String> getKeys() {
        return parent.getKeys();
    }

    @Override
    protected Object handleGetObject(String key) {
        return parent.getObject(key);
    }
}
