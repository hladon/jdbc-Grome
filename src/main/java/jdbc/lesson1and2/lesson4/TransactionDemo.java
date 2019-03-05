package jdbc.lesson1and2.lesson4;

import jdbc.lesson1and2.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionDemo {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.ctmtirr3ce0v.us-east-2.rds.amazonaws.com:1521:orcl";

    private static final String USER = "main";
    private static final String PASS = "QWer1234";



    public static void save(List<Product> products) {

        try (Connection connection = getConnection()) {
            saveList(products,connection);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }

    }

    private static void saveList(List<Product> products,Connection connection) throws SQLException{
        try (PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PRODUCT VALUES (?,?,?,?)")) {

            connection.setAutoCommit(false);

            for (Product product:products) {
                preparedStatement.setLong(1, product.getId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setString(3, product.getDescription());
                preparedStatement.setInt(4, product.getPrice());

                int res=preparedStatement.executeUpdate();
                System.out.println("save was fished with result "+res);
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }
    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
