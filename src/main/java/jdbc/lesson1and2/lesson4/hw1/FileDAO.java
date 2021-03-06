package jdbc.lesson1and2.lesson4.hw1;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class FileDAO extends DAO<File> {


    public File save(File file) throws SQLException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO FILES VALUES (?,?,?,?,?)")) {
            preparedStatement.setLong(1, file.getId());
            preparedStatement.setString(2, file.getName());
            preparedStatement.setString(3, file.getFormat());
            preparedStatement.setLong(4, file.getSize());
            if (file.getStorage() == null) {
                preparedStatement.setNull(5, Types.NUMERIC);
            } else {
                preparedStatement.setLong(5, file.getStorage().getId());
            }
            preparedStatement.execute();
        } catch (SQLException sql) {

            throw sql;
        }
        return file;
    }

    public File update(File file) throws SQLException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE FILES SET NAME=? ," +
                " FORMAT=?,FILE_SIZE=?,STORAGE_ID=? WHERE ID=?")) {
            preparedStatement.setString(1, file.getName());
            preparedStatement.setString(2, file.getFormat());
            preparedStatement.setLong(3, file.getSize());
            if (file.getStorage() == null) {
                preparedStatement.setNull(4, Types.NUMERIC);
            } else {
                preparedStatement.setLong(4, file.getStorage().getId());
            }
            preparedStatement.setLong(5, file.getId());
            preparedStatement.execute();
        } catch (SQLException sql) {
            throw sql;
        }
        return file;
    }

    public void updateList(List<File> files) throws SQLException {
        connection.setAutoCommit(false);
        try{
        for (File file:files) {
            update(file);
            }
        } catch (SQLException sql) {
                connection.rollback();
                throw sql;
            }
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void saveList(List<File> files) throws SQLException {
        connection.setAutoCommit(false);
        try{
            for (File file:files) {
                save(file);
            }
        } catch (SQLException sql) {
            connection.rollback();
            throw sql;
        }
        connection.commit();
        connection.setAutoCommit(true);
    }

    public List<File> getFilesByStorage(Storage storage) throws SQLException {
        List<File> list = new LinkedList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT*FROM FILES WHERE STORAGE_ID=?")) {
            preparedStatement.setLong(1, storage.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(getObject(resultSet));
            }
        }
        return list;
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                " DELETE FROM FILES WHERE ID=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException sql) {
            throw sql;
        }
    }

    public File findById(long id) throws SQLException {
            try (PreparedStatement statement = getConnection().prepareStatement("SELECT*FROM FILES WHERE ID=?")) {
                statement.setLong(1,id);
                ResultSet resultSet = statement.getResultSet();
                return getObject(resultSet);
            } catch (SQLException sql) {
                throw sql;
            }
    }
    public File qetResult(String query) throws SQLException {
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                return getObject(resultSet);
            }
        } catch (SQLException sql) {
            throw sql;
        }
        return null;
    }
    public long getStorageFreeSpace(Storage storage) throws SQLException {
        long usedSpace = 0;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT SUM(FILE_SIZE) FROM FILES WHERE STORAGE_ID=?")) {
            preparedStatement.setLong(1, storage.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usedSpace = resultSet.getLong(1);
            }
        }
        return storage.getStorageMaxSize() - usedSpace;
    }

    private File getObject(ResultSet resultSet) throws SQLException {
        StorageDAO storageDAO = new StorageDAO();
        return new File(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
                storageDAO.findById(resultSet.getLong(5)));
    }


}
