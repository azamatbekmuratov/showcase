package azamat.bank.controller;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.repository.api.person.PersonRepository;
import azamat.bank.services.api.person.PersonService;
import azamat.bank.services.model.person.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by Azamat on 4/11/2016.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    private Validator validator = null;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * @param personDto
     * @return JsonResponse
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse addUser(@RequestBody PersonDto personDto) {
        return personService.addUser(personDto, validator);
    }

}
