package tw.demo.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Channel
 * @Date: 2020/11/10
 * @Time: 5:10 PM
 */
public class Channel {


    public static void main(String[] args) throws Exception{
//
//        String str = "1234,人";
//
//        FileOutputStream fileOutputStream = new FileOutputStream("data/log.txt");
//
//        FileChannel channel = fileOutputStream.getChannel();
//
//        ByteBuffer allocate = ByteBuffer.allocate(1024);
//
//        allocate.put(str.getBytes());
//
//        allocate.flip();
//
//        channel.write(allocate);



        FileInputStream fileOutputStream = new FileInputStream("data/log.txt");

        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(2);

//        allocate.put(str.getBytes());

        allocate.flip();

        channel.read(allocate);


    }
}
