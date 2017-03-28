package azamat.bank.services.model.user;

/**
 * Created by Azamat on 4/10/2016.
 */
public class ResponseText {
    private String authenticated;

    private String userLogin;

    public String getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(String authenticated) {
        this.authenticated = authenticated;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
