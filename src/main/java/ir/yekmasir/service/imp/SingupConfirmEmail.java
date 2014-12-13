package ir.yekmasir.service.imp;

import ir.yekmasir.model.User;
import ir.yekmasir.service.SingupConfirmService;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/13/14
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class SingupConfirmEmail implements SingupConfirmService {

    private SecureRandom random = new SecureRandom();


    @Override
    public User doConfirm(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User startConfirm(User user, WebAppContext context) {
        String code = new BigInteger(130, random).toString(32);
        user.setEmailConfirmToken(code);
        return user;
    }
}
