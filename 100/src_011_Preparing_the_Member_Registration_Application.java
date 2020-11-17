package book.javamvc.jpa.i18n;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;

public class BundleForEL extends ResourceBundle {
    private BundleForEL(Locale locale, String baseName) {
        setLocale(locale, baseName);
    }

    public static void setFor(HttpServletRequest request,
        String i18nAttributeName, String i18nBaseName) {
      if (request.getSession().
            getAttribute(i18nAttributeName) == null) {
          request.getSession().setAttribute(
            i18nAttributeName, 
            new BundleForEL(request.getLocale(), 
                            i18nBaseName));
        }
    }

     public void setLocale(Locale locale, 
           String baseName) {
        if (parent == null || 
              !parent.getLocale().equals(locale)) {
            setParent(getBundle(baseName, locale));
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
