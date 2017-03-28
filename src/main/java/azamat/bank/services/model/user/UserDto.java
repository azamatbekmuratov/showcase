package azamat.bank.services.model.user;

import azamat.bank.common.services.model.JsonResponse;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto implements JsonResponse {

    private long id;

    @Email
    @NotNull
    private String email;

    @Size(min = 2, max = 512)
    @NotNull
    private String login;

    @Size(min = 2, max = 512)
    @NotNull
    private String password;

    public UserDto() {

    }

    public UserDto(long id, String login, String password, String email) {

        this.id = id;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}