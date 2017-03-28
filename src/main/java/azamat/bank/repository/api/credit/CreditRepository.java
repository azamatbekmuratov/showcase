package azamat.bank.repository.api.credit;

import azamat.bank.repository.model.credit.Credit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by Azamat on 4/11/2016.
 */
public interface CreditRepository extends CrudRepository<Credit, Long>{
    default boolean checkCredit(String iin) {
        return this.findByIin(iin) != null;
    }

    @Query(value="Select c from Credit c where c.iin = :iin")
    @Transactional
    ArrayList<Credit> findByIin(@Param("iin") String iin);
}
