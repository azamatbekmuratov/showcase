package azamat.bank.repository.api.user;

import azamat.bank.repository.model.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     *
     * @param id
     * @return if user with such id exists.
     */
    default boolean userExists(String id) {
        return this.findOne(Long.parseLong(id)) != null;
    }

    default boolean checkUser(String login, String password) {
        return this.findByLogin(login, password) != null;
    }

    @Query(value="Select u from User u where u.login = :login AND u.password = :password")
    @Transactional
    User findByLogin(@Param("login") String login, @Param("password") String password);

}
