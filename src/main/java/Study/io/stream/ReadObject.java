package Study.io.stream;

import sun.plugin.dom.core.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("C:\\Users\\lenovo\\workspace\\LeetCode\\user.txt"));
            User u = (User) ois.readObject();
            System.out.println(u.getName()+","+u.getPassword()+","+u.getMoney());
        } catch (IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
