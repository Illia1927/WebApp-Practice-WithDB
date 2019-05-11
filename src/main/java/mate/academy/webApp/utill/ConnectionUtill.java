package mate.academy.webApp.utill;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtill {
    private static final Logger logger = Logger.getLogger(ConnectionUtill.class);
    private static final String URL = "jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "edcwsxqaz22";
    private static Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Connection successfully");
        } catch (ClassNotFoundException e) {
            logger.error("JDBC Driver was not loaded :", e);
            System.exit(1);
        } catch (SQLException e) {
            logger.error("Connection to DB was not established: ", e);
            System.exit(1);
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}

