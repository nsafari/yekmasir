package ir.yekmasir.service;

import ir.yekmasir.model.User;
import ir.yekmasir.service.imp.WebAppContext;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/8/14
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SingupConfirmService {

    User doConfirm(User user);

    User startConfirm(User user, WebAppContext context);
}
