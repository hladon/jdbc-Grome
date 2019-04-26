package jdbc.lesson1and2.lesson4.hw1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Service {
    private static FileDAO fileDAO = new FileDAO();
    private static StorageDAO storageDAO = new StorageDAO();


    public static void put(Storage storage, File file) throws Exception {
        try (Connection connection = DAO.getConnection()) {
            connection.setAutoCommit(false);
            putFile(storage, file, connection);
            connection.commit();
        }
    }

    public static void putAll(Storage storage, List<File> files) throws Exception {
        try (Connection connection = DAO.getConnection()) {
            connection.setAutoCommit(false);
            putList(storage, files, connection);
            connection.commit();
        }

    }

    public static void delete(Storage storage, File file) throws Exception {
        try (Connection connection =DAO.getConnection()) {
            connection.setAutoCommit(false);
            remove(storage, file, connection);
            connection.commit();
        }
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        try (Connection connection = DAO.getConnection()) {
            connection.setAutoCommit(false);
            List<File> list = fileDAO.getFilesByStorage(storageFrom);
            putList(storageTo, list, connection);
            connection.commit();
        }
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        try (Connection connection = DAO.getConnection()) {
            connection.setAutoCommit(false);
            File file = fileDAO.findById(id);
            remove(storageFrom, file, connection);
            putFile(storageTo, file, connection);
            connection.commit();
        }
    }
    private static File putFile(Storage storage, File file, Connection connection) throws Exception {
        try {
            init(storage, file);
            file.setStorage(storage);
            storage.setStorageMaxSize(storage.getStorageMaxSize() - file.getSize());
            fileDAO.update(file);
            storageDAO.update(storage);
            return file;
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }
    }

    private static void putList(Storage storage, List<File> files, Connection connection) throws Exception {
        try {
            for (File file : files) {
                init(storage, file);
                if (file.getStorage() != null)
                    remove(file.getStorage(), file, connection);
                file.setStorage(storage);
                fileDAO.update(file);
                storage.setStorageMaxSize(storage.getStorageMaxSize() - file.getSize());
                storageDAO.update(storage);
            }
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

    }


    private static void remove(Storage storage, File file, Connection connection) throws Exception {
        try {
            if (file.getStorage() == null || !file.getStorage().equals(storage)) {
                throw new Exception("File " + file.getId() + " don`t belong to storage " + storage.getId());

            }
            storage.setStorageMaxSize(storage.getStorageMaxSize() + file.getSize());
            file.setStorage(null);
            fileDAO.update(file);
            storageDAO.update(storage);
        } catch (SQLException sql) {
            connection.rollback();
            throw sql;
        }

    }

    private static void init(Storage storage, File file) throws Exception {
        boolean allowed = false;
        if (storage == null || file == null) {
            throw new Exception("Wrong input");
        }
        if (storage.getStorageMaxSize() < file.getSize()) {
            System.out.println("File to big for this storage");
            throw new Exception("File " + file.getId() + " to big for storage " + storage.getId());
        }
        for (String type : storage.getFormatsSupported()) {
            if (file.getFormat().equalsIgnoreCase(type)) {
                allowed = true;
                break;
            }
        }
        if (!allowed) {
            throw new Exception("Storage " + storage.getId() + "don`t support type of file " + file.getId());
        }
    }

}
