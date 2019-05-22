package jdbc.lesson1and2.lesson4.hw1;


import java.sql.SQLException;
import java.util.List;

public class Controller {
    private static StorageDAO storageDAO = new StorageDAO();
    private static FileDAO fileDAO = new FileDAO();

    public static void put(Storage storage, File file) throws Exception {
        Service.put(storage, file);
    }

    public static void putAll(Storage storage, List<File> files) throws Exception {
        Service.putAll(storage, files);

    }

    public static void delete(Storage storage, File file) throws Exception {
        Service.delete(storage, file);
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        Service.transferAll(storageFrom, storageTo);
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        Service.transferFile(storageFrom, storageTo, id);
    }

    public static File findFileById(long id) throws SQLException {
        return fileDAO.findById(id);
    }

    public static Storage findStorageById(long id) throws SQLException {
        return storageDAO.findById(id);
    }

    public static void update(File file) throws SQLException {
        fileDAO.update(file);
    }

    public static void update(Storage storage) throws SQLException {
        storageDAO.update(storage);
    }

    public static List<File> getFilesByStorage(Storage storage) throws SQLException {
        return fileDAO.getFilesByStorage(storage);
    }

    public static Storage save(Storage storage) throws SQLException {
        storageDAO.save(storage);
        return storage;
    }

    public static File save(File file) throws SQLException {
        fileDAO.save(file);
        return file;
    }
}
