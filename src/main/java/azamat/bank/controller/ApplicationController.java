package azamat.bank.controller;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.repository.api.application.ApplicationRepository;
import azamat.bank.services.api.application.ApplicationService;
import azamat.bank.services.model.application.ApplicationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by Azamat on 4/10/2016.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ApplicationService applicationService;

    private Validator validator = null;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<ApplicationDto> getApplication(String iin) {
        return applicationService.getApplication(iin);
    }

    /**
     * @param applicationDto
     * @return JsonResponse
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse addApplication(@RequestBody ApplicationDto applicationDto) {
        return applicationService.addApplication(applicationDto, validator);
    }
}
