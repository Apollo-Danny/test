package tw.demo.demo;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: ThreadTest
 * @Date: 2019/5/31
 * @Time: 下午4:03
 */

public class ThreadTest {


    private static ExecutorService threadPool = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            new ThreadPoolExecutor.AbortPolicy());


    /**
     * 初始化需要等待的 3 个事件
     */
    private static CountDownLatch latch = new CountDownLatch(4);

    public static void main(String[] args) throws InterruptedException {
        /**
         * 创建 3 个线程去执行事件
         */
        new Thread(() -> {
            System.out.println("*****_*****1");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("*****_*****2");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("*****_*****3");
            latch.countDown();
        }).start();


        new Thread(() -> {

        }).start();
//         在计数器为 0 之前会一直阻塞
        latch.await();


        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);


        threadPool.execute(new DownLoad());

        System.out.println("~~~~~_~~~~~");

    }

    private static class DownLoad implements Runnable{

        @Override
        public void run() {
            System.out.println("123");
        }
    }

}
