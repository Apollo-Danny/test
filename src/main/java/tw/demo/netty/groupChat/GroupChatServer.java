package tw.demo.netty.groupChat;

import org.apache.ibatis.annotations.SelectKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: GroupChatServer
 * @Date: 2020/11/10
 * @Time: 6:56 PM
 */
public class GroupChatServer {

    private ServerSocketChannel listerChannel = null;
    private Selector selector = null;

    private GroupChatServer() throws Exception{
        listerChannel = ServerSocketChannel.open();
        selector = Selector.open();
        listerChannel.socket().bind(new InetSocketAddress(6666));
        listerChannel.configureBlocking(false);
        listerChannel.register(selector, SelectionKey.OP_ACCEPT);
    }


    public static void main(String[] args) throws Exception{
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.lister();
    }


    public void lister() throws Exception{
        while (true){
            int select = selector.select(2000);
            if(select > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        SocketChannel src = listerChannel.accept();
                        src.register(selector,SelectionKey.OP_READ);
                        System.out.println(src.getRemoteAddress() + "上线了-----");
                    }
                    if(key.isReadable()){
                       this.readData(key);
                    }
                    iterator.remove();
                }
            }else{
                System.out.println("等待中----");
            }
        }
    }


    public void readData(SelectionKey key){
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer intBuffer = ByteBuffer.allocate(1024);
        int read = 0;
        try {
            read = socketChannel.read(intBuffer);
            if(read > 0){
                String msg = new String(intBuffer.array());
                System.out.println("from   客户端---" + msg);
                sendToOtherClients(msg,socketChannel);
            }
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + "已经离线----");
                key.cancel();
                selector.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void sendToOtherClients(String msg,SocketChannel socketChannel){
        System.out.println("转发消息中----");
        Set<SelectionKey> keys = selector.keys();
        keys.stream().
                filter(key -> (key.channel() instanceof SocketChannel && key.channel() != socketChannel ))
                .forEach( ss -> {
                    SocketChannel socketChannel1 = (SocketChannel)ss.channel();
                    ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                    try {
                        socketChannel1.configureBlocking(false);
                        socketChannel1.write(wrap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
