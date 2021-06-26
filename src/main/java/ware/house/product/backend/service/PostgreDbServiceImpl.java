package ware.house.product.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class PostgreDbServiceImpl implements DbService {
    @Value("org.postgresql.Driver")
    private String driverName;

    @Value("jdbc:postgresql://localhost/ATL")
    private String url;

    @Value("postgres")
    private String username;

    @Value("Pass1234")
    private String password;

    @Override
    public Connection connection() {
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
