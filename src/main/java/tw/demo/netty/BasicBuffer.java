package tw.demo.netty;

import java.nio.IntBuffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: BasicBuffer
 * @Date: 2020/11/10
 * @Time: 4:35 PM
 */
public class BasicBuffer {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for(int i = 0 ;i < intBuffer.capacity();i++){
            System.out.println(i * 2);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
