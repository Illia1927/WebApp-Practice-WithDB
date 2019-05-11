package mate.academy.webApp.model;

public class User {
    private Long userId;
    private String name;
    private String login;
    private String password;
    private String email;
    private ROLE role;

    public User(Long userId, String name, String login, String password, String email, String role) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = ROLE.valueOf(role);
    }

    public User(String name, String login, String email, String password, String role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = ROLE.valueOf(role);
    }

    public int getRoleIndex() {
        int ordinal = role.ordinal();
        return ordinal++;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = ROLE.valueOf(role);
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

    public enum ROLE {
        ADMIN,
        USER
    }

    @Override
    public String toString() {
        return "User{" +
                "users_id=" + userId +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        return getRole() == user.getRole();

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }
}
