package azamat.bank.repository.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String login;
    private String password;
    private String email;

    @Transient
    private Date createdAt;

    @Transient
    private Date updatedAt;

    public User() {
    }

    public User(long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return new Date(createdAt.getTime());
    }

    public Date getUpdatedAt() {
        return new Date(updatedAt.getTime());
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, login='%s', password='%s', email='%s'], createdAt='%s', updatedAt='%s'",
                id, login, password, email, createdAt, updatedAt);
    }

   /* @Override
    public String toString() {
        return "User[id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + "]";
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

}