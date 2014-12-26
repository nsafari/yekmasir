package ir.yekmasir.service;

import ir.yekmasir.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/8/14
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SignupConfirmService {

    User doConfirm(User user);

    User startConfirm(User user);
}
