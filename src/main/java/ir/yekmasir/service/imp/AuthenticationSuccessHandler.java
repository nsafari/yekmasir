package ir.yekmasir.service.imp;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/30/14
 * Time: 8:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
//        response.addCookie(new Cookie("JSESSIONID", RequestContextHolder.currentRequestAttributes().getSessionId()));
        response.getWriter().println("{\"result\": \"login succeeded\"}");
        response.getWriter().flush();

    }

}
