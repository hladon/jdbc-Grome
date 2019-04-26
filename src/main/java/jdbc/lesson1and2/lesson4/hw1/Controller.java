package jdbc.lesson1and2.lesson4.hw1;


import java.util.List;

public class Controller {

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
}
