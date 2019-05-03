package jdbc.lesson1and2.lesson4.hw1;


import java.util.List;

public class Service {
    private static FileDAO fileDAO = new FileDAO();


    public static File put(Storage storage, File file) throws Exception {
        checkRestrictions(storage,file);
        file.setStorage(storage);
        fileDAO.save(file);
        return file;
    }

    public static void putAll(Storage storage, List<File> files) throws Exception {
        for (File file:files){
            put(storage,file);
        }
    }

    public static void delete(Storage storage, File file) throws Exception {
        if (file.getStorage().equals(storage)){
            file.setStorage(null);
            fileDAO.update(file);
        }
    }
    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File file=fileDAO.findById(id);
        transfer(storageFrom,storageTo,file);
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        List<File> list=fileDAO.getFilesByStorage(storageFrom);
        for (File file:list){
            transfer(storageFrom,storageTo,file);
        }
    }

    private static void transfer(Storage storageFrom, Storage storageTo,File file) throws Exception{
        if (file==null||!file.getStorage().equals(storageFrom)){
            throw new Exception("File "+file.getId()+" don`t exist in storage "+storageFrom.getId() );
        }
        checkRestrictions(storageTo,file);
        file.setStorage(storageTo);
        fileDAO.update(file);
    }


    private static void checkRestrictions(Storage storage, File file) throws Exception {
        boolean allowed = false;
        if (storage == null || file == null) {
            throw new Exception("Wrong input");
        }
        if (fileDAO.getStorageFreeSpace(storage) < file.getSize()) {
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
            throw new Exception("Storage " + storage.getId() + " don`t support type of file " + file.getId());
        }
    }

}
