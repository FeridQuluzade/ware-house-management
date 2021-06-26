package ware.house.product.backend.dao;


import ware.house.product.backend.model.WareHouseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ware.house.product.backend.service.DbService;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WareHouseRepository {
    private final DbService dbService;

    @Autowired
    public WareHouseRepository(DbService dbService) {
        this.dbService=dbService;
    }

    public List<WareHouseProduct> retrieveAll() {
        try {
            List<WareHouseProduct> wareHouseProducts = new ArrayList<>();

            Connection connection = dbService.connection();
            String query = "select * from warehouse_product";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("productid");
                String name = resultSet.getString("name");
                long count = resultSet.getLong("count");
                double buyRate = resultSet.getDouble("buy_rate");
                double sellRate = resultSet.getDouble("sell_rate");
                wareHouseProducts.add(new WareHouseProduct(id, name, count, buyRate, sellRate,count*(sellRate-buyRate)));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return wareHouseProducts;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public Optional<WareHouseProduct> retrieveById(long id) {

        try {
            Optional<WareHouseProduct> optionalWareHouseProduct = Optional.empty();

            Connection connection = dbService.connection();

            String query = "select * from warehouse_product where productid=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                long count = resultSet.getLong("count");
                double buy_rate = resultSet.getDouble("buy_rate");
                double sell_rate = resultSet.getDouble("sell_rate");
                WareHouseProduct wareHouseProduct = new WareHouseProduct(id, name, count, buy_rate, sell_rate,count*(sell_rate-buy_rate));
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
            Connection connection = dbService.connection();

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
            Connection connection = dbService.connection();

            String query = "Update warehouse_product set name=?,count=?,buy_rate=?,sell_rate=?,updated_date=?" +
                    "where productid=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, wareHouseProduct.getName());
            preparedStatement.setLong(2, wareHouseProduct.getCount());
            preparedStatement.setDouble(3, wareHouseProduct.getBuyRate());
            preparedStatement.setDouble(4, wareHouseProduct.getSellRate());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(wareHouseProduct.getUpdatedDate()));
            preparedStatement.setLong(6, wareHouseProduct.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteById(long id) {
        try {
            Connection connection = dbService.connection();

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