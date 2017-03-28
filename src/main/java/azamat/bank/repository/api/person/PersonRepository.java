package azamat.bank.repository.api.person;

import azamat.bank.repository.model.person.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by Azamat on 4/10/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Long>{
    default boolean checkPerson(String iin) {
        return this.findByIin(iin) != null;
    }

    @Query(value="Select p from Person p where p.iin = :iin")
    @Transactional
    ArrayList<Person> findByIin(@Param("iin") String iin);

}
