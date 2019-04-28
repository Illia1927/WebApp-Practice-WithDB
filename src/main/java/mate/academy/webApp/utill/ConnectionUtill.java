package mate.academy.webApp.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtill {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "edcwsxqaz22";
    private static Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver was not loaded : ");
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Connection to DB was not established: ");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}

