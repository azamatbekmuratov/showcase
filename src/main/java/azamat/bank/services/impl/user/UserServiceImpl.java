package azamat.bank.services.impl.user;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.common.services.model.ResponseManager;
import azamat.bank.common.services.model.ResponseStatus;
import azamat.bank.repository.api.user.UserRepository;
import azamat.bank.repository.model.user.User;
import azamat.bank.services.api.user.UserService;
import azamat.bank.services.impl.mapper.UserMapper;
import azamat.bank.services.model.user.ResponseText;
import azamat.bank.services.model.user.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Azamat on 4/17/2016.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ResponseText checkUser(String login, String password) {
        System.out.println("login is:" + login + "pass is : " +password);
        ResponseText result = new ResponseText();
        String passwordHush = passwordHashing(password);
        if (userRepository.checkUser(login, passwordHush)) {
            result.setAuthenticated(ResponseStatus.SUCCESS.getStatus());
            result.setUserLogin(login);
        }
        else {
            result.setAuthenticated(ResponseStatus.FAILED.getStatus());
        }
        return result;
    }

    public String passwordHashing(String passwordToHush){
        String passwordHush = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(passwordToHush.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwordHush = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return passwordHush;

    }

    /**
     * @return Iterable
     */
    public Iterable<UserDto> getUsers() {
        ArrayList<UserDto> result = new ArrayList<>();

        userRepository.findAll().forEach(
                entity -> result.add(UserMapper.INSTANCE.userToUserDto(entity))
        );

        return result;
    }

    /**
     * @param user
     * @return JsonResponse
     */
    public JsonResponse addUser(UserDto user, Validator validator) {
        ResponseManager rm = new ResponseManager();

        Set<ConstraintViolation<UserDto>> constraintViolations = validator.validate(user);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<UserDto> error : constraintViolations) {
                rm.addError(error.getPropertyPath().toString() + " : " + error.getMessage());
            }
            return rm.getResponse();
        }

        User entity = UserMapper.INSTANCE.userDtoToUser(user);

        try {
            userRepository.save(entity);
            return UserMapper.INSTANCE.userToUserDto(entity);
        } catch (Exception e) {
            rm.addError("general : Something went wrong, please contact admin.");
            log.error(e.toString());
        }
        return rm.getResponse();
    }

    /**
     * @param id
     * @param user
     * @return JsonResponse
     */
    public JsonResponse updateUser(String id, UserDto user, Validator validator) {
        ResponseManager rm = new ResponseManager();

        if (!userRepository.userExists(id)) {
            rm.addError("general : User does not exist.");
            return rm.getResponse();
        }

        Set<ConstraintViolation<UserDto>> constraintViolations = validator.validate(user);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<UserDto> error : constraintViolations) {
                rm.addError(error.getPropertyPath().toString() + " : " + error.getMessage());
            }
            return rm.getResponse();
        }

        User entity = UserMapper.INSTANCE.userDtoToUser(user);

        try {
            userRepository.save(entity);
            return UserMapper.INSTANCE.userToUserDto(entity);
        } catch (Exception e) {
            rm.addError("general : Something went wrong, please contact admin.");
            log.error(e.toString());
        }
        return rm.getResponse();
    }

    /**
     * Delete user
     *
     * @param id
     * @return JsonResponse
     */
    public JsonResponse deleteUser(String id) {
        ResponseManager rm = new ResponseManager();

        if (!userRepository.userExists(id)) {
            rm.addError("general : User does not exist.");
            return rm.getResponse();
        }

        try {
            userRepository.delete(Long.parseLong(id));
        } catch (Exception e) {
            rm.addError("general : Something went wrong, please contact admin.");
            log.error(e.toString());
        }
        return rm.getResponse();
    }
}
