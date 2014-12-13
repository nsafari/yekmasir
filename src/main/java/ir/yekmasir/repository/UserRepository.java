package ir.yekmasir.repository;

import ir.yekmasir.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/21/14
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    User findByEmailConfirmToken(String emailConfirmToken);

}
