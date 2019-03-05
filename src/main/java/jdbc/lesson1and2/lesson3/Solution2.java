package jdbc.lesson1and2.lesson3;



import java.sql.*;


public class Solution2 {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.ctmtirr3ce0v.us-east-2.rds.amazonaws.com:1521:orcl";

    private static final String USER = "main";
    private static final String PASS = "QWer1234";

    public long testSavePerfomance() {
        long startTime=System.currentTimeMillis();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO TEST_SPEED VALUES (?,?,?)")) {

            for (int i=1;i<=1000;i++){
                preparedStatement.setLong(1,i);
                preparedStatement.setString(2,"test");
                preparedStatement.setInt(3,i*3);

                int res=preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return System.currentTimeMillis()-startTime;
    }
    public long testDeleteByIdPerfomance() {
        long startTime=System.currentTimeMillis();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM TEST_SPEED WHERE ID=?")) {

            for (int i=1;i<=1000;i++){
                preparedStatement.setLong(1,i);
                int res=preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return System.currentTimeMillis()-startTime;
    }

    public long testDeletePerfomance() {
        long startTime=System.currentTimeMillis();
        try (Connection connection = getConnection();
             Statement statement=connection.createStatement()) {

           statement.execute("DELETE FROM TEST_SPEED WHERE ID<=1000");

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return System.currentTimeMillis()-startTime;
    }

    public long testSelectByIdPerfomance() {
        long startTime=System.currentTimeMillis();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM TEST_SPEED WHERE ID=?")) {

            for (int i=1;i<=1000;i++){
                preparedStatement.setLong(1,i);
                ResultSet res=preparedStatement.executeQuery();
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return System.currentTimeMillis()-startTime;
    }

    public long testSelectPerfomance() {
        long startTime=System.currentTimeMillis();
        try (Connection connection = getConnection();
             Statement statement=connection.createStatement()) {

           ResultSet res= statement.executeQuery("SELECT * FROM TEST_SPEED WHERE ID<=1000");

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return System.currentTimeMillis()-startTime;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
