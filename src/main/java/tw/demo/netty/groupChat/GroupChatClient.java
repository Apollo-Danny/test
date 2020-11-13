package tw.demo.netty.groupChat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: GroupChatClient
 * @Date: 2020/11/10
 * @Time: 7:25 PM
 */
public class GroupChatClient {

    private String userName;
    private SocketChannel socketChannel;
    private Selector selector;

    private String ip = "127.0.0.1";
    private Integer port = 6666;

    private GroupChatClient() throws Exception{
        socketChannel = SocketChannel.open(new InetSocketAddress(ip,port));
        selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(userName + "   is  ok ----");
    }

    public void sendInfo(String msg) throws Exception{
        msg = userName.concat("说   ").concat(msg);
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }

    public void readInfo() throws Exception{
        int select = selector.select();
        if(select > 0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isReadable()){
                    SocketChannel so = (SocketChannel) key.channel();
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    so.read(allocate);
                    String s = new String(allocate.array());
                    System.out.println(s);
                }
                iterator.remove();
            }
        }else {
            System.out.println("没有可用的通到----");
        }
    }


    public static void main(String[] args) throws Exception{
        GroupChatClient groupChatClient = new GroupChatClient();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                while (true){
                    groupChatClient.readInfo();
                    Thread.sleep(3000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String next = scanner.next();
            groupChatClient.sendInfo(next);
        }

    }
}
