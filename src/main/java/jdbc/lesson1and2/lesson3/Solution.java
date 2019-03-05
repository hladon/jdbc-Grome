package jdbc.lesson1and2.lesson3;

import jdbc.lesson1and2.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.ctmtirr3ce0v.us-east-2.rds.amazonaws.com:1521:orcl";

    private static final String USER = "main";
    private static final String PASS = "QWer1234";

    public List<Product> findProductsByPrice(int price, int delta) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ?")) {

            preparedStatement.setInt(1, price - delta);
            preparedStatement.setInt(2, price + delta);

            ResultSet resultSet = preparedStatement.executeQuery();
            return makeProductList(resultSet);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findProductsByName(String word) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE NAME= ?")) {

            preparedStatement.setString(1, word);

            ResultSet resultSet = preparedStatement.executeQuery();
            return makeProductList(resultSet);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findProductsWithEmptyDescription() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT*FROM PRODUCT  WHERE (DESCRIPTION IS NULL OR DESCRIPTION='')");

            return makeProductList(resultSet);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    private List<Product> makeProductList(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4));
            products.add(product);
        }
        return products;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
