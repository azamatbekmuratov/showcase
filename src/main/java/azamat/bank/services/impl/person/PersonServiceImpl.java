package azamat.bank.services.impl.person;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.common.services.model.ResponseManager;
import azamat.bank.repository.api.person.PersonRepository;
import azamat.bank.repository.model.person.Person;
import azamat.bank.services.api.person.PersonService;
import azamat.bank.services.impl.mapper.PersonMapper;
import azamat.bank.services.model.person.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Azamat on 4/17/2016.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public JsonResponse addUser(@RequestBody PersonDto personDto, Validator validator) {
        ResponseManager rm = new ResponseManager();

        Set<ConstraintViolation<PersonDto>> constraintViolations = validator.validate(personDto);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<PersonDto> error : constraintViolations) {
                rm.addError(error.getPropertyPath().toString() + " : " + error.getMessage());
            }
            return rm.getResponse();
        }

        Person entity = PersonMapper.INSTANCE.personDtoToPerson(personDto);

        try {
            personRepository.save(entity);
            return PersonMapper.INSTANCE.personToPersonDto(entity);
        } catch (Exception e) {
            rm.addError("general : Системная ошибка. Пожалуйста обратитесь к системному администратору.");
            log.error(e.toString());
        }
        return rm.getResponse();
    }


}
