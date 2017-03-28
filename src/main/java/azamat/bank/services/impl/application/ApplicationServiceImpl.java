package azamat.bank.services.impl.application;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.common.services.model.ResponseManager;
import azamat.bank.repository.api.application.ApplicationRepository;
import azamat.bank.repository.model.application.Application;
import azamat.bank.services.api.application.ApplicationService;
import azamat.bank.services.impl.mapper.ApplicationMapper;
import azamat.bank.services.model.application.ApplicationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Azamat on 4/17/2016.
 */
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Iterable<ApplicationDto> getApplication(String iin) {
        System.out.println("Application requested by IIN:" + iin);

        ArrayList<ApplicationDto> result = new ArrayList<>();

        applicationRepository.findByIin(iin).forEach(
                entity -> result.add(ApplicationMapper.INSTANCE.applicationToApplicationDto(entity))
        );

        return result;
    }

    public JsonResponse addApplication(@RequestBody ApplicationDto applicationDto, Validator validator) {
        ResponseManager rm = new ResponseManager();

        Set<ConstraintViolation<ApplicationDto>> constraintViolations = validator.validate(applicationDto);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<ApplicationDto> error : constraintViolations) {
                rm.addError(error.getPropertyPath().toString() + " : " + error.getMessage());
            }
            return rm.getResponse();
        }

        Application entity = ApplicationMapper.INSTANCE.applicationDtoToApplication(applicationDto);
        try {
            applicationRepository.save(entity);
            return ApplicationMapper.INSTANCE.applicationToApplicationDto(entity);
        } catch (Exception e) {
            rm.addError("general : Системная ошибка. Пожалуйста обратитесь к системному администратору.");
            log.error(e.toString());
        }
        return rm.getResponse();
    }


}
