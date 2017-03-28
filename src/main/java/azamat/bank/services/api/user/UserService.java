package azamat.bank.services.api.user;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.services.model.user.ResponseText;
import azamat.bank.services.model.user.UserDto;

import javax.validation.Validator;

/**
 * Created by Azamat on 4/17/2016.
 */
public interface UserService {

    ResponseText checkUser(String login, String password);

    Iterable<UserDto> getUsers();

    JsonResponse addUser(UserDto user, Validator validator);

    JsonResponse updateUser(String id, UserDto user, Validator validator);

    JsonResponse deleteUser(String id);

}
