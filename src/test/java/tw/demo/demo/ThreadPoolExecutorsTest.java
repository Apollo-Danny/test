package tw.demo.demo;

import com.alibaba.fastjson.JSONObject;
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

    @Test
    public void test03(){

//        @Test
//        public void initReq(){
//            JSONObject contentJson = new JSONObject();
//            contentJson.put("userIdNum","370828199303261318");
//            contentJson.put("appSecret","9FE7B8F95FC9247109028ADD9D49AC59");
//            contentJson.put("vehicleld","闽A8696F_1");
//
//            JSONObject userObject = new JSONObject();
//            userObject.put("appid","0000001002");
//            userObject.put("token","");
//
//            JSONObject pageObject = new JSONObject();
//            pageObject.put("pageNo",1);
//            pageObject.put("pageSize",10);
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("signType",1);
//            jsonObject.put("_uri","public/login/user?by=useridnum");
//            jsonObject.put("user",userObject);
//            jsonObject.put("reqTime",new Date());
//            jsonObject.put("content",contentJson);
//            jsonObject.put("page",pageObject);
//            String fjgstMD5Str = MD5Utils.getFjgstMD5Str(jsonObject, "9FE7B8F95FC9247109028ADD9D49AC59");
//            String md5Str = MD5Utils.md5(fjgstMD5Str);
//            jsonObject.put("sign",md5Str);
//            System.out.println(jsonObject.toJSONString());
//            String url = "http://mintongbao.mgskj.com/etctest/public/login/user?by=useridnum";
//            String result2 = HttpRequest.post(url).body(jsonObject.toJSONString()).header("version","01").header("Content-Type","application/json")
//                    .execute().body();
//            log.info("返回参数---{}", result2);
//
//        }

    }



}
