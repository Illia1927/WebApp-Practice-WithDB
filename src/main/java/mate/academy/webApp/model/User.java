package mate.academy.webApp.model;

import mate.academy.webApp.utill.PasswordEncoder;
import mate.academy.webApp.utill.RandomHelper;
import org.apache.log4j.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements AutoCloseable {
    private static final Logger LOGGER = Logger.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long userId;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_to_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    @Column
    private String salt;

    public User() {
    }

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public User(String name, String login, String email, String password, List<Role> roles) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.salt = RandomHelper.getRandomSalt();
        this.password = PasswordEncoder.getEncodePassword(password, salt);
        this.roles = roles;
    }

    public User(String name, String login, String email, String password, Role... roles) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.salt = RandomHelper.getRandomSalt();
        this.password = PasswordEncoder.getEncodePassword(password, salt);
        this.roles.addAll(Arrays.asList(roles));
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getRoles(), user.getRoles()) &&
                Objects.equals(getSalt(), user.getSalt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getLogin(), getEmail(), getPassword(), getRoles(), getSalt());
    }

    @Override
    public void close() {
        LOGGER.debug("Closing!");
    }

    public enum ROLE {
        ADMIN,
        USER
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
