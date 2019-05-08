package mate.academy.webApp.dao.impl;

import mate.academy.webApp.dao.GoodDao;
import mate.academy.webApp.model.Good;
import mate.academy.webApp.utill.ConnectionUtill;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class GoodDaoImpl implements GoodDao {
    private static final Connection connection = ConnectionUtill.getConnection();
    private static final Logger logger = Logger.getLogger(GoodDaoImpl.class);

    @Override
    public void addGood(Good good) {
        String ADD_GOOD = "INSERT INTO goods(name_of_good, description, price) VALUE (?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_GOOD);
            statement.setString(1, good.getNameOfGood());
            statement.setString(2, good.getDiscription());
            statement.setDouble(3, good.getPrice());
            statement.execute();
            logger.info("insert good is done");
            logger.debug(ADD_GOOD);
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }

    @Override
    public void updateGood(Long id, Good good) {
        String UPDATE_GOOD =
                "UPDATE goods SET name_of_good=?, description=?, price=? WHERE good_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_GOOD);
            statement.setString(1, good.getNameOfGood());
            statement.setString(2, good.getDiscription());
            statement.setDouble(3, good.getPrice());
            statement.setLong(4, id);
            statement.executeUpdate();
            logger.info("update good is done");
            logger.debug(UPDATE_GOOD);
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }

    @Override
    public void deleteGoodById(Long id) {
        String DELETE_GOOD_BY_ID = "DELETE FROM goods WHERE good_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_GOOD_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            logger.info("delete good is done");
            logger.debug(DELETE_GOOD_BY_ID);
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }

    @Override
    public Optional<Good> getGoodById(Long id) {
        String GET_GOOD_BY_NAME = "SELECT * FROM goods WHERE good_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(GET_GOOD_BY_NAME);
            statement.setLong(1, id);
            ResultSet getByNameResultSet = statement.executeQuery();
            while (getByNameResultSet.next()) {
                Long goodsId = getByNameResultSet.getLong("good_id");
                String nameOfGood = getByNameResultSet.getString("name_of_good");
                String description = getByNameResultSet.getString("description");
                Double price = Double.valueOf(getByNameResultSet.getLong("price"));
                return Optional.of(new Good(goodsId, nameOfGood, description, price));
            }
            logger.info("get good by name is done");
            logger.debug(GET_GOOD_BY_NAME);
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Good> getAllGood() {
        ArrayList<Good> allGoods = new ArrayList<>();
        Good temporary;
        String GET_ALL_GOOS = "SELECT * FROM goods";
        try {
            Statement statement = connection.createStatement();
            ResultSet getAllResultSet = statement.executeQuery(GET_ALL_GOOS);
            while (getAllResultSet.next()) {
                Long goodsId = getAllResultSet.getLong("good_id");
                String nameOfGood = getAllResultSet.getString("name_of_good");
                String description = getAllResultSet.getString("description");
                Double price = Double.valueOf(getAllResultSet.getLong("price"));
                temporary = new Good(goodsId, nameOfGood, description, price);
                allGoods.add(temporary);
            }
            logger.info("get all goods is done");
            logger.debug(GET_ALL_GOOS);
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
        return allGoods;
    }
}
