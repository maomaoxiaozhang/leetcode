package Study.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by lenovo on 2017/11/29.
 */
public class Client {
    public static void main(String[] args) {
        String serverName = "10.108.166.14";
        int port = 6666;
        try {
            System.out.println("连接到：" + serverName + " ，端口号：" + port);
            Socket socket = new Socket(serverName, port);
            System.out.println("远程主机地址：" + socket.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello from " + socket.getLocalSocketAddress());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println(in.readUTF());
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
