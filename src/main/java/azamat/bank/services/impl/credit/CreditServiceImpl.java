package azamat.bank.services.impl.credit;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.common.services.model.ResponseManager;
import azamat.bank.repository.api.credit.CreditRepository;
import azamat.bank.repository.model.credit.Credit;
import azamat.bank.services.api.credit.CreditService;
import azamat.bank.services.impl.mapper.CreditMapper;
import azamat.bank.services.model.application.ResponseCalculation;
import azamat.bank.services.model.credit.CreditDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Azamat on 4/17/2016.
 */
@Service
@Transactional
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository creditRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public JsonResponse addCredit(CreditDto creditDto, Validator validator) {
        ResponseManager rm = new ResponseManager();

        Set<ConstraintViolation<CreditDto>> constraintViolations = validator.validate(creditDto);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<CreditDto> error : constraintViolations) {
                rm.addError(error.getPropertyPath().toString() + " : " + error.getMessage());
            }
            return rm.getResponse();
        }

        Credit entity = CreditMapper.INSTANCE.creditDtoToCredit(creditDto);

        try {
            creditRepository.save(entity);
            return CreditMapper.INSTANCE.creditToCreditDto(entity);
        } catch (Exception e) {
            rm.addError("general : Системная ошибка. Пожалуйста обратитесь к системному администратору.");
            log.error(e.toString());
        }
        return rm.getResponse();
    }

    public ResponseCalculation calculate(String amount, String contractDuration, String rate) {
        ResponseCalculation result = new ResponseCalculation();

        Long amountConverted = Long.valueOf(amount);
        Long contractDurationConverted = Long.valueOf(contractDuration);
        Long rateConverted = Long.valueOf(rate);

        Long monthlyAmount = amountConverted/contractDurationConverted;
        Long totalAmountPayments = monthlyAmount * contractDurationConverted;
        Long overPayment = totalAmountPayments - amountConverted;

        result.setMonthlyAmount(monthlyAmount.toString());
        result.setTotalAmountPayments(totalAmountPayments.toString());
        result.setOverPayment(overPayment.toString());
        return result;
    }

}
