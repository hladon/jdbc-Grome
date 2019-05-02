package jdbc.lesson1and2.lesson4.hw1;

import java.sql.*;

abstract class DAO<T> {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.ctmtirr3ce0v.us-east-2.rds.amazonaws.com:1521:orcl";
    private static final String USER = "main";
    private static final String PASS = "QWer1234";

    protected static Connection connection = null;


    public void deleteQuery( String query) throws SQLException {
        getConnection();
        try (Statement statement = connection.createStatement()) {

            statement.execute(query);

        }catch (SQLException sql) {
            connection.rollback();
            throw sql;
        }
    }

    public T qetResult(String query) throws SQLException{
        getConnection();
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                return getObject(resultSet);
            }

        }catch (SQLException sql) {
            throw sql;
        }
        return null;
    }



    abstract T getObject(ResultSet resultSet) throws SQLException;

    public static Connection getConnection() throws SQLException {
        if(connection==null)
        connection= DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }

}
