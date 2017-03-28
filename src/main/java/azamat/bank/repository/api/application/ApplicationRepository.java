package azamat.bank.repository.api.application;

/**
 * Created by Azamat on 4/10/2016.
 */

import azamat.bank.repository.model.application.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * ApplicationRepository
 */
public interface ApplicationRepository extends CrudRepository<Application, Long> {

    default boolean checkApplication(String iin) {
        return this.findByIin(iin) != null;
    }

    @Query(value="Select a from Application a where a.iin = :iin")
    @Transactional
    ArrayList<Application> findByIin(@Param("iin") String iin);
}
