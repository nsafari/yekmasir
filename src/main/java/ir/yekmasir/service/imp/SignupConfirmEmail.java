package ir.yekmasir.service.imp;

import ir.yekmasir.model.User;
import ir.yekmasir.service.SignupConfirmService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/13/14
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class SignupConfirmEmail implements SignupConfirmService {

    private SecureRandom random = new SecureRandom();

    @Autowired
    private HtmlEmail htmlEmail;


    @Override
    public User doConfirm(User user) {
        if(!user.isEnabled()){
            user.setUserEnabled(true);
            user.setConfirmed(true);
            user.setConfirmDate(new Date());
        }
        return user;
    }

    @Override
    public User startConfirm(User user) throws EmailException {
        String code = new BigInteger(130, random).toString(32);
        user.setEmailConfirmToken(code);
        htmlEmail.addTo(user.getEmail(), user.getFamily());
        htmlEmail.setSubject("تایید مشخصات کاربری");
        htmlEmail.setHtmlMsg(getaHtmlMessage(code));
        htmlEmail.setTextMsg("Your email client does not support HTML message");
        htmlEmail.send();
        user.setVerificationEmailSent(true);
        return user;
    }

    private String getaHtmlMessage(String code) {
        return "<tbody style=\"direction: rtl;text-align: right\"><tr>" +
        "<td align=\"center\" valign=\"top\">" +
        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">" +
        "<tbody><tr>" +
        "<td>" +
        "<h1 style=\"font-size:28px;margin-bottom:30px;margin-top:0;padding:0\">yekmasir.com</h1>" +
        "</td>" +
        "</tr>" +
        "</tbody></table>" +
        "</td>" +
        "</tr>" +
        "<tr>" +
        "<td align=\"center\" valign=\"top\">" +
        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-radius:6px;background-color:#ffffff\">" +
        "<tbody><tr>" +
        "<td align=\"right\" valign=\"top\" style=\"line-height:150%;font-family:Helvetica;font-size:14px;color:#333333;padding:20px\">" +
        "<h2 style=\"font-size:22px;line-height:28px;margin:0 0 12px 0\">لطفا عضویت خود را تایید نمایید" +
        "</h2>" +
        "<a href=\"localhost/user/verifyEmail?code=" + code + "\" style=\"color:#ffffff!important;display:inline-block;font-weight:500;font-size:16px;line-height:42px;font-family:'Helvetica',Arial,sans-serif;width:auto;white-space:nowrap;min-height:42px;margin:12px 5px 12px 0;padding:0 22px;text-decoration:none;text-align:center;border:0;border-radius:3px;vertical-align:top;background-color:#5d5d5d!important\" target=\"_blank\"><span style=\"display:inline;font-family:'Helvetica',Arial,sans-serif;text-decoration:none;font-weight:500;font-style:normal;font-size:16px;line-height:42px;border:none;background-color:#5d5d5d!important;color:#ffffff!important\">بله عضویت من در سایت مورد تایید است</span></a>" +
        "<br>" +
        "<div><p style=\"padding:0 0 10px 0\">اگر شما این ایمیل را به اشتباه دریافت کرده اید به سادگی حذفش نمایید. بدون تایید شما فرایند عضویت انجام نمی پذیرد.</p>" +
        "</div>" +
        "<span>" +
        "<span content=\"ما نیاز داریم شما ایمیل خود را تایید نمایید.\"></span>" +
        "<span>" +
        "<span>" +
        "</span>" +
        "</span>" +
        "</span>" +
        "</td>" +
        "</tr>" +
        "</tbody></table>" +
        "</td>" +
        "</tr>" +
        "<tr>" +
        "<td align=\"center\" valign=\"top\">" +
        "<table border=\"0\" cellpadding=\"20\" cellspacing=\"0\" width=\"600\">" +
        "<tbody><tr>" +
        "<td align=\"center\" valign=\"top\">" +
        "<div>" +
        "</div>" +
        "</td>" +
        "</tr>" +
        "</tbody></table>" +
        "</td>" +
        "</tr>" +
        "</tbody>";
    }

}
