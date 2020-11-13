package tw.demo.netty;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: NioService
 * @Date: 2020/11/10
 * @Time: 6:41 PM
 */
public class NioService {


    public static void main(String[] args) throws Exception{
        ServerSocketChannel open = ServerSocketChannel.open();
        Selector selector = Selector.open();
        open.socket().bind(new InetSocketAddress(6666));
        open.configureBlocking(false);
        open.register(selector, SelectionKey.OP_ACCEPT);
        while (true){

        }


    }
}
