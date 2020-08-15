package tw.demo.demo;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: ThreadPoolTest01
 * @Date: 2019/6/28
 * @Time: 上午11:10
 */
public class ThreadPoolTest01 {

    static Vector<String> list = new Vector<String>();

    static {
        for (int i = 0 ; i<100; i++){
            list.add("票编号："+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ; i<10; i++){
            while (list.size() > 0){
                Thread.sleep(1_000);
                new Thread(() -> System.out.println("售票了。。。"+list.remove(0))).start();
            }
        }
    }
}
