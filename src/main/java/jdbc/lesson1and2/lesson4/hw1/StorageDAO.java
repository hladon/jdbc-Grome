package jdbc.lesson1and2.lesson4.hw1;

import java.sql.*;
import java.util.Arrays;

public class StorageDAO extends DAO<Storage> {


    public Storage save(Storage storage) throws SQLException{
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("INSERT INTO STORAGE VALUES (?,?,?,?)")) {

            preparedStatement.setLong(1,storage.getId());
            preparedStatement.setString(2, arrayToString(storage.getFormatsSupported()));
            preparedStatement.setString(3,storage.getStorageCountry());
            preparedStatement.setLong(4,storage.getStorageMaxSize());

            preparedStatement.execute();

        } catch (SQLException sql) {

            throw sql;
        }

        return storage;
    }

    public Storage update(Storage storage) throws SQLException{
        try (    PreparedStatement preparedStatement=getConnection().prepareStatement("UPDATE STORAGE SET " +
                     " FORMATS_SUPPORTED=?,STORAGE_COUNTRY=?,STORAGE_MAX_SIZE=? WHERE ID=?")) {

            preparedStatement.setString(1,arrayToString(storage.getFormatsSupported()));
            preparedStatement.setString(2,storage.getStorageCountry());
            preparedStatement.setLong(3,storage.getStorageMaxSize());
            preparedStatement.setLong(4,storage.getId());

            preparedStatement.execute();

        }catch (SQLException sql) {

            throw sql;
        }
        return storage;
    }

    public void delete (long id)throws SQLException{
        String query="DELETE FROM FILES WHERE ID="+id;
        deleteQuery(query);

    }

    public Storage findById(long id) throws SQLException{
        String query="SELECT*FROM STORAGE WHERE ID="+id;
        return qetResult(query);
    }
    private static String arrayToString(String[] theAray) {
        String result = "";

        for (int i = 0; i < theAray.length; i++) {
            result = result + theAray[i];
            if (i!=theAray.length-1) {
                result = result + ",";
            }

        }

         return result;
    }

    protected Storage getObject(ResultSet resultSet) throws SQLException {
        return new Storage(resultSet.getLong(1),resultSet.getString(2).split(","),resultSet.getString(3),resultSet.getLong(4));
    }


}
