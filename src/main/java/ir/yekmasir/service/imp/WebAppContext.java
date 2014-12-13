package ir.yekmasir.service.imp;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/8/14
 * Time: 7:47 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class WebAppContext {
    private Locale locale;

    public WebAppContext(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }

    abstract public String getAppUrl();
}
