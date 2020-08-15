package tw.demo.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Thread01
 * @Date: 2019/7/4
 * @Time: 上午10:21
 */
public class Thread01 implements Callable<Integer> {
    public static void main(String[] args) throws Exception {

        Thread01 thread01 = new Thread01();

        FutureTask<Integer> futureTask = new FutureTask<>(thread01);

        Thread thread = new Thread(futureTask);

        thread.start();

        Integer result =futureTask.get();

        System.out.println("返回结果"+result);
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("线程执行了"+Thread.currentThread().getName());
        Thread.sleep(2_000);
        return 1;
    }
}
