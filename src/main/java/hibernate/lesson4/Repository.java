package lesson36;


import lesson36.model.IdEntity;
import lesson36.model.User;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Repository {
    public static String repositoryLocation="";
    public static String convert(String line){
        return line;
    }

    public  List getList() throws Exception {
        List list=new LinkedList();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(repositoryLocation))) {
            while ((line = br.readLine()) != null) {
                list.add(convert(line));
            }
        } catch (IOException io) {
            throw new IOException("File " + repositoryLocation + " are missing");
        }
        return list;
    }

    public static  <T> void save(List<T> list, String repositoryPath) throws IOException{
        StringBuffer stringList=new StringBuffer();
        for (T line: list){
            stringList.append(line.toString());
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(repositoryPath, false))) {
            br.write(String.valueOf(stringList));
        } catch (IOException io) {
            throw new  IOException("File " + repositoryPath + " not exist!");
        }
    }

    public  <T extends IdEntity> T findById(long id) throws Exception{
        List <T> list= getList();
        for (int i=0; i<list.size();i++){
            if (list.get(i).getId()==id)
                return list.get(i);
        }
        return null;
    }




}
