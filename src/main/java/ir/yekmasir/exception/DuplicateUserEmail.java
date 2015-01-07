package ir.yekmasir.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 1/4/15
 * Time: 8:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class DuplicateUserEmail extends Exception {
    public DuplicateUserEmail(String s) {
        super(s);
    }
}
