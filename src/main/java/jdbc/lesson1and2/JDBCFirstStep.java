package jdbc.lesson1and2;

import java.sql.*;

public class JDBCFirstStep {
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.ctmtirr3ce0v.us-east-2.rds.amazonaws.com:1521:orcl";

    private static final String USER = "main";
    private static final String PASS = "QWer1234";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = conn.createStatement()) {
            try {

                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + " not found");
                return;
            }

            try (ResultSet rs = statement.executeQuery("SELECT * FROM TEST  ")) {

                while (rs.next()) {
                    System.out.println("Object found");
                }
            }


        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }

    }
}
