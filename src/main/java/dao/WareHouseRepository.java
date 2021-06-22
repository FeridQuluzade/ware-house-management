package dao;

import dto.WareHouseCreateDto;
import model.WareHouseProduct;
import shared.PostgreDbService;

import java.sql.*;
import java.util.Optional;

public class WareHouseRepository {
    private final PostgreDbService postgreDbService;

    public WareHouseRepository() {
        postgreDbService = new PostgreDbService();
    }

    public Optional<WareHouseProduct> retrieveById(long id) {

        try {
            Optional<WareHouseProduct> optionalWareHouseProduct = Optional.empty();

            Connection connection = postgreDbService.connection();

            String query = "select * from warehouse_product where productid=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Long count = resultSet.getLong("count");
                double buy_rate = resultSet.getDouble("buy_rate");
                double sell_rate = resultSet.getDouble("sell_rate");
                WareHouseProduct wareHouseProduct = new WareHouseProduct(id, name, count, buy_rate, sell_rate);
                optionalWareHouseProduct = Optional.of(wareHouseProduct);
            }

            resultSet.close();
            preparedStatement.close();
            resultSet.close();

            return optionalWareHouseProduct;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

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
            preparedStatement.setLong(1, wareHouseProduct.getCount());
            preparedStatement.setDouble(2, wareHouseProduct.getBuyRate());
            preparedStatement.setDouble(3, wareHouseProduct.getSellRate());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(wareHouseProduct.getUpdatedDate()));
            preparedStatement.setLong(5, wareHouseProduct.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteByİd(long id) {
        try {
            Connection connection = postgreDbService.connection();

            String query = "DELETE   from warehouse_product " +
                    "where  productid=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
