package azamat.bank.services.api.credit;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.services.model.application.ResponseCalculation;
import azamat.bank.services.model.credit.CreditDto;

import javax.validation.Validator;

/**
 * Created by Azamat on 4/17/2016.
 */
public interface CreditService {

    JsonResponse addCredit(CreditDto creditDto, Validator validator);

    ResponseCalculation calculate(String amount, String contractDuration, String rate);

}
