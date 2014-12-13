package ir.yekmasir.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/13/14
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserNotActiveException extends AuthenticationException {
    public UserNotActiveException(String username) {
        super(username);
    }
}
