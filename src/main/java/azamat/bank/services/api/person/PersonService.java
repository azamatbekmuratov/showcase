package azamat.bank.services.api.person;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.services.model.person.PersonDto;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Validator;

/**
 * Created by Azamat on 4/17/2016.
 */
public interface PersonService {

    JsonResponse addUser(@RequestBody PersonDto personDto, Validator validator);

}
