package Study.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lenovo on 2017/11/29.
 */
public class Server implements Runnable{
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
//        serverSocket.setSoTimeout(1000*10);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("等待连接...");
                Socket socket = serverSocket.accept();
                System.out.println("远程主机为：" + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("连接断开...");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 6666;
        try {
            new Thread(new Server(port)).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
