package jdbc.lesson1and2;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.ctmtirr3ce0v.us-east-2.rds.amazonaws.com:1521:orcl";

    private static final String USER = "main";
    private static final String PASS = "QWer1234";


    public static void changeDescription() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = conn.createStatement()) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + " not found");
                return;
            }
            List<String> list = new LinkedList<>();
            try (ResultSet rs = statement.executeQuery("SELECT * FROM PRODUCT WHERE LENGTH(DESCRIPTION)>100")) {
                while (rs.next()) {

                    String[] description = rs.getString(3).split("\\.");
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < description.length - 1; i++) {
                        result.append(description[i]);
                        result.append(".");
                    }
                    String resultString = result.toString();
                    if (resultString.isEmpty())
                        continue;
                    list.add("UPDATE PRODUCT SET DESCRIPTION=\'" + resultString + "\' WHERE ID=" + rs.getInt(1));
                }

                for (String cm : list) {
                    System.out.println(cm);
                    statement.execute(cm);
                }
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static void increasePrice() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = conn.createStatement()) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Class " + JDBC_DRIVER + " not found");
                return;
            }
            List<String> list = new LinkedList<>();
            try (ResultSet rs = statement.executeQuery("SELECT * FROM PRODUCT WHERE PRICE<=970")) {
                while (rs.next()) {
                    list.add("UPDATE PRODUCT SET PRICE=" + (rs.getInt(4) + 100) + " WHERE ID=" + rs.getLong(1));
                }
            }
            for (String cm : list) {
                statement.execute(cm);
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }

    }

}
