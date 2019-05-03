package mate.academy.webApp.dao;

import mate.academy.webApp.model.User;
import mate.academy.webApp.utill.ConnectionUtill;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Connection connection = ConnectionUtill.getConnection();
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Override
    public void addUser(User user) {
        String ADD_USER = "INSERT INTO users(name, login, email, password, role) VALUE (?, ?, ?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getRoleIndex());
            statement.execute();
            logger.info("insert user is done");
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }

    @Override
    public void updateUser(Long id, User user) {
        String UPDATE_USER =
                "UPDATE users SET name=?, login=?, email=?, password=?, role=? WHERE user_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getRoleIndex());
            statement.setLong(6, id);
            statement.executeUpdate();
            logger.info("update user is done");
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            logger.info("delete user is done");
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }

    @Override
    public Optional<User> getUserByName(String name) {
        String GET_USER_BY_NAME = "SELECT user_id, name, login, email, password, role_name " +
                " FROM users INNER JOIN role " +
                " on users.role = role.role_id WHERE name=?";
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_NAME);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long usersId = rs.getLong("user_id");
                String userName = rs.getString("name");
                String login = rs.getString("login");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role_name");
                return Optional.of(new User(usersId, userName, login, email, password, role));
            }
            logger.info("get user by name is done");
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<>();
        User temporary;
        String GET_ALL_USERS = "SELECT *" +
                " FROM users INNER JOIN role" +
                " ON users.role = role.role_id";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                Long usersId = resultSet.getLong("user_id");
                String userName = resultSet.getString("name");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role_name");
                temporary = new User(usersId, userName, login, email, password, role);
                result.add(temporary);
            }
            logger.info("get all users is done");
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
        return result;
    }
}
