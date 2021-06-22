package dao;

import dto.WareHouseCreateDto;
import model.WareHouseProduct;
import shared.PostgreDbService;

import java.sql.*;

public class WareHouseRepository {
    private final PostgreDbService postgreDbService;

    public WareHouseRepository() {
        postgreDbService= new PostgreDbService();
    }

    public long create(WareHouseProduct wareHouseProduct) {

        try {
            Connection connection = postgreDbService.connection();

            String query = "insert  into warehouse_product(name,count,buy_rate,sell_rate,created_date) " +
                    "values(?,?,?,?,?)" +
                    "returning productid";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, wareHouseProduct.getName());
            preparedStatement.setLong(2, wareHouseProduct.getCount());
            preparedStatement.setDouble(3, wareHouseProduct.getBuyRate());
            preparedStatement.setDouble(4, wareHouseProduct.getSellRate());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(wareHouseProduct.getCreatedDate()));


            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            long id = resultSet.getLong(1);

            connection.close();
            preparedStatement.close();
            resultSet.close();

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void update(WareHouseProduct wareHouseProduct) {
        try {
            Connection connection = postgreDbService.connection();

            String query = "Update warehouse_product set count=?,buy_rate=?,sell_rate=?,updated_date=?" +
                    "where productid=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,wareHouseProduct.getCount());
            preparedStatement.setDouble(2,wareHouseProduct.getBuyRate());
            preparedStatement.setDouble(3,wareHouseProduct.getSellRate());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(wareHouseProduct.getUpdatedDate()));
            preparedStatement.setLong(5,wareHouseProduct.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
