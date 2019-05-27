package mate.academy.webApp.dao.impl;

import mate.academy.webApp.dao.CodeDao;
import mate.academy.webApp.model.Code;
import mate.academy.webApp.utill.ConnectionUtill;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CodeDaoImpl implements CodeDao {
    private static final Connection connection = ConnectionUtill.getConnection();
    private static final Logger logger = Logger.getLogger(CodeDaoImpl.class);

    @Override
    public void addCode(Code code) {
        String ADD_CODE = "INSERT INTO code(users_id, goods_id, `values`) VALUES (?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_CODE);
            statement.setLong(1, code.getUserId());
            statement.setLong(2, code.getGoodId());
            statement.setString(3, code.getValue());
            statement.executeUpdate();
            logger.info("insert code is done");
            logger.debug(ADD_CODE);
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }

    @Override
    public Optional<Code> getCodeByValue(String value) {
        String GET_CODE_BY_VALUE = "SELECT code_id, users_id, goods_id, `values`" +
                " FROM code WHERE `values`=?";
        try {
            PreparedStatement statement = connection.prepareStatement(GET_CODE_BY_VALUE);
            statement.setString(1, value);
            ResultSet getCodeByValueResultSet = statement.executeQuery();
            while (getCodeByValueResultSet.next()) {
                Long codeId = getCodeByValueResultSet.getLong("code_id");
                Long usersId = getCodeByValueResultSet.getLong("users_id");
                Long goodId = getCodeByValueResultSet.getLong("goods_id");
                String valueFromDb = getCodeByValueResultSet.getString("values");
                return Optional.of(new Code(codeId, usersId, goodId, valueFromDb));
            }
            logger.info("get code by value is done");
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Code> getCodeById(Long userId, String value) {
        String GET_CODE_BY_ID = "SELECT * " +
                " FROM code WHERE users_id=? and `values`=?";
        try {
            PreparedStatement statement = connection.prepareStatement(GET_CODE_BY_ID);
            statement.setLong(1, userId);
            statement.setString(2, value);
            ResultSet getCodeByIdResultSet = statement.executeQuery();
            while (getCodeByIdResultSet.next()) {
                Long codeId = getCodeByIdResultSet.getLong("code_id");
                Long usersId = getCodeByIdResultSet.getLong("users_id");
                Long goodId = getCodeByIdResultSet.getLong("goods_id");
                String valueFromDb = getCodeByIdResultSet.getString("values");
                return Optional.of(new Code(codeId, usersId, goodId, valueFromDb));
            }
            logger.info("get code by id is done");
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
        return Optional.empty();
    }

    @Override
    public void deleteCodeById(Long id) {
        String DELETE_CODE_BY_ID = "DELETE FROM code WHERE code_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CODE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            logger.info("delete code is done");
            logger.debug(DELETE_CODE_BY_ID);
        } catch (SQLException e) {
            logger.error("check your sql query", e);
        }
    }
}
