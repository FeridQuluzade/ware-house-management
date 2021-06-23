package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreDbServiceImpl implements DbService {

    private final String URL = "jdbc:postgresql://localhost/ATL";
    private final String USER = "postgres";
    private final String PASSWORD = "Pass1234";
    private final String DRIVER_NAME = "org.postgresql.Driver";

    @Override
    public Connection connection() {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
