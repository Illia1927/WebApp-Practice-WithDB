package mate.academy.webApp.dao;

import mate.academy.webApp.model.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserDao {
    Long addUser(User user);

    void updateUser(Long id, User user);

    void deleteUserById(Long id);

    Optional<User> getUserByName(String name);

    Optional<User> getUserById(Long id);

    ArrayList<User> getAllUsers();
}
