package azamat.bank.services.api.application;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.services.model.application.ApplicationDto;

import javax.validation.Validator;

/**
 * Created by Azamat on 4/17/2016.
 */
public interface ApplicationService {

    Iterable<ApplicationDto> getApplication(String iin);

    JsonResponse addApplication(ApplicationDto applicationDto, Validator validator);
}
