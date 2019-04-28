package mate.academy.webApp.model;

public class User {
    private Long users_id;
    private String name;
    private String login;
    private String password;
    private String email;

    public User(Long users_id, String name, String login,String email, String password) {
        this.users_id = users_id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User(String name, String login, String email, String password) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
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
    public String toString() {
        return "User{" +
                "users_id=" + users_id +
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

        if (getUsers_id() != null ? !getUsers_id().equals(user.getUsers_id()) : user.getUsers_id() != null)
            return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        return getEmail() != null ? getEmail().equals(user.getEmail()) : user.getEmail() == null;

    }

    @Override
    public int hashCode() {
        int result = getUsers_id() != null ? getUsers_id().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
