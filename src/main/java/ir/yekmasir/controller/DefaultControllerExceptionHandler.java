package ir.yekmasir.controller;

import ch.qos.logback.core.net.SocketConnector;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 1/7/15
 * Time: 6:59 AM
 * To change this template use File | Settings | File Templates.
 */
@ControllerAdvice
public class DefaultControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorhandler(Exception e){
        return e.getMessage();
    }

}
