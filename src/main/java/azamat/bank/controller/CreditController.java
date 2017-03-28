package azamat.bank.controller;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.repository.api.credit.CreditRepository;
import azamat.bank.services.api.credit.CreditService;
import azamat.bank.services.model.application.ResponseCalculation;
import azamat.bank.services.model.credit.CreditDto;
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
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    CreditRepository creditRepository;

    @Autowired
    CreditService creditService;

    private Validator validator = null;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CreditController(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * @param creditDto
     * @return JsonResponse
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse addCredit(@RequestBody CreditDto creditDto) {
        return creditService.addCredit(creditDto, validator);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calculate")
    public ResponseCalculation calculate(String amount, String contractDuration, String rate) {
        return creditService.calculate(amount, contractDuration, rate);
    }



}
