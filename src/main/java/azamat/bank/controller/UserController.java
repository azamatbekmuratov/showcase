package azamat.bank.controller;

import azamat.bank.common.services.model.JsonResponse;
import azamat.bank.repository.api.user.UserRepository;
import azamat.bank.services.api.user.UserService;
import azamat.bank.services.model.user.ResponseText;
import azamat.bank.services.model.user.UserDto;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private Validator validator = null;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ResponseText checkUser(String login, String password) {
        return userService.checkUser(login, password);
    }

    /**
     * @return Iterable
     */
    @RequestMapping(method = RequestMethod.GET)
    Iterable<UserDto> getUsers() {
        return userService.getUsers();
    }

    /**
     * @param user
     * @return JsonResponse
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse addUser(@RequestBody UserDto user) {
        return userService.addUser(user, validator);
    }

    /**
     * @param id
     * @param user
     * @return JsonResponse
     */
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public
    @ResponseBody
    JsonResponse updateUser(@PathVariable String id, @RequestBody UserDto user) {
        return userService.updateUser(id, user, validator);
    }

    /**
     * Delete user
     *
     * @param id
     * @return JsonResponse
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    JsonResponse deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}