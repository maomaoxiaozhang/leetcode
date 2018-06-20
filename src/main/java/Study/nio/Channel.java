package Study.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {
    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\lenovo\\Desktop\\file.txt", "rw");
            FileChannel channel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(20);
//            int count = channel.read(buffer);
//            while (count != -1) {
//                buffer.flip();
//                while (buffer.hasRemaining())
//                    System.out.println((char)buffer.get());
//                buffer.clear();
//                count = channel.read(buffer);
//            }
            String date = "today " + System.currentTimeMillis();
            buffer.put(date.getBytes());
            buffer.flip();
            while (buffer.hasRemaining())
                channel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
