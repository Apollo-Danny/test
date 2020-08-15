package tw.demo.demo;

import org.junit.Test;
import sun.text.resources.BreakIteratorInfo;

import javax.swing.text.StyledEditorKit;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 可缓存线程池
 * @author: baixiaobai
 * @className: ThreadPoolExecutorsTest
 * @Date: 2019/6/26
 * @Time: 下午3:15
 */
public class ThreadPoolExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
       for(int i = 0;i<100;i++){
           executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
       }
       executorService.shutdown();
    }



    @Test
    public void scheduledTest(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        while (true){
            scheduledExecutorService.schedule(() -> System.out.println(Thread.currentThread().getName()),3, TimeUnit.SECONDS);
//            scheduledExecutorService.shutdown();
        }
    }
    @Test
    public void test01(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "AA");
        map.put("2", "BB");
        map.put("3", "CC");
        map.put("4", "DD");

        Collection<String> valueCollection = map.values();
        final int size = valueCollection.size();

        List<String> valueList = new ArrayList<String>(valueCollection);

        String[] valueArray = new String[size];

        map.values().toArray(valueArray);

    }
    @Test
    public void test02(){

        BlockingQueue<String> ss = new LinkedBlockingDeque<>(2);

        new Thread(() -> {
            try {
                System.out.println("1111");
                ss.put("123");
                ss.put("123");
                ss.put("123");
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> System.out.println("2222")).start();

        ArrayList<String> strings = new ArrayList<>();


    }



}
