package lesson36;

import lesson36.Exceptions.RepositoryDamaged;
import lesson36.model.User;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserRepository extends Repository {
    private static String repositoryLocation = "src\\lesson36\\repository\\UserDb";



    public static void saveUser(List<User> roomList ) throws IOException {

        save(roomList,repositoryLocation);
    }


    private static User convertToUser(String line) throws RepositoryDamaged{
        if (line==null)
            return null;
        String[] values = line.split(",");
        if (values.length!=5)
            throw new RepositoryDamaged("Repository " + repositoryLocation + " are damaged") ;
        return new User(Long.valueOf(values[0]),values[1],values[2],values[3],
                UserType.valueOf(values[4]));
    }
}
