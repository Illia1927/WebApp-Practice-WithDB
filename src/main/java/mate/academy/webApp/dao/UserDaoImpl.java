package mate.academy.webApp.dao;

import mate.academy.webApp.model.User;
import mate.academy.webApp.utill.ConnectionUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Connection connection = ConnectionUtill.getConnection();

    @Override
    public void addUser(User user) {
        String ADD_USER = "INSERT INTO users(name, login, email, password) VALUE (?, ?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        String UPDATE_USER =
                "UPDATE users SET name=?, login=?, email=?, password=? WHERE users_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setLong(5, user.getUsers_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserById(Long id) {
        String DELETE_USER_BY_ID = "DELETE FROM users WHERE users_id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> getUserByName(String name) {
        String GET_USER_BY_NAME = "SELECT * FROM users WHERE name=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_NAME);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long users_id = rs.getLong("users_id");
                String userName = rs.getString("name");
                String login = rs.getString("login");
                String email = rs.getString("email");
                String password = rs.getString("password");
                return Optional.of(new User(users_id, userName, login, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<>();
        User temporary;
        String GET_ALL_USERS = "SELECT * FROM users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                Long users_id = resultSet.getLong("users_id");
                String userName = resultSet.getString("name");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                temporary = new User(users_id, userName, login, email, password);
                result.add(temporary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
