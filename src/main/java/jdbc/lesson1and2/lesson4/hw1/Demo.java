package jdbc.lesson1and2.lesson4.hw1;


import java.util.ArrayList;
import java.util.List;

public class Demo {


    public static void main(String[] args) throws Exception {
        File  file1 =new File(1,"Test","txt",1000,null);
        File  file2 =new File(2,"Test2","jpg",2500,null);
        File  file3 =new File(3,"Test3","doc",5000,null);
        File  file4 =new File(4,"Test4","txt",6000,null);
        String[] formats = {"txt","jpg"};
        Storage storage=new Storage((long)1,formats,"Ukraine",23000);
        String[] formats1 = {"txt","doc"};
        Storage storage1=new Storage((long)2,formats1,"Denmark",30000);
        List<File> list=new ArrayList<>();
        List<File> list2=new ArrayList<>();
        list.add(file1);
        list.add(file4);
        list2.add(file1);
        list2.add(file3);
        Storage storage2=new Storage((long)19,formats1,"Denmark",4500);
        FileDAO fileDAO=new FileDAO();
        System.out.println(fileDAO.getStorageFreeSpace(storage2));
//        Controller.save(storage);
//        Controller.save(storage1);
//        Controller.save(file1);
//        Controller.save(file2);
//        Controller.save(file3);
//        Controller.save(file4);
//        Controller.put(Controller.findStorageById(1),Controller.findFileById(1));
//        System.out.println(Controller.findFileById(1));
//        System.out.println(Controller.findStorageById(1));
//
//        Controller.delete(Controller.findStorageById(1),Controller.findFileById(1));
//        System.out.println(Controller.findFileById(1));
//        System.out.println(Controller.findStorageById(1));
//
//
//
//        Controller.putAll(Controller.findStorageById(1),list);
//        Controller.putAll(Controller.findStorageById(2),list2);
//        System.out.println(Controller.findFileById(1));
//        System.out.println(Controller.findStorageById(1));
//
//        Controller.transferAll(Controller.findStorageById(1),Controller.findStorageById(2));
//        System.out.println(Controller.findFileById(1));
//        System.out.println(Controller.findStorageById(1));
//
//        Controller.transferFile(Controller.findStorageById(2),Controller.findStorageById(1),1);
//        System.out.println(Controller.findFileById(1));
//        System.out.println(Controller.findStorageById(2));
//
//
//        for (File file:Controller.getFilesByStorage(Controller.findStorageById(1))){
//            System.out.println(file);
//        }

    }




}
