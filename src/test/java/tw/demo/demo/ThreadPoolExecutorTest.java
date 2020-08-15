package tw.demo.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: ThreadPoolExecutorTest
 * @Date: 2019/6/26
 * @Time: 下午2:49
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        ThreadPoolExecutor poolExecuter =
                new ThreadPoolExecutor(100,100,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100));
        for(int i = 0;i<20;i++){
            poolExecuter.execute(new TestThread());
        }
        poolExecuter.shutdown();

    }

     static class TestThread implements Runnable{

        @Override
        public void run() {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection(
                        "jdbc:postgresql://gp-2zeq0rcjhu03h027vo.gpdb.rds.aliyuncs.com:3432/trawe", "trawe",
                        "AxeqyxjIloM0nYqwuD@xM3z6Aw3f");
                c.setAutoCommit(false);
                System.out.println("连接数据库成功！");
                stmt = c.createStatement();
                long t = System.currentTimeMillis();
                for(int i = 0;i<100000;i++){
                    SimpleDateFormat simpleDateFormat;
                    simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
                    String date=simpleDateFormat.format(new Date());
                    Random random=new Random();
                    int rannum= (int)(random.nextDouble()*(99999-10000 + 1))+ 10000;
                    String rand=date+rannum;
                    String plateNo = rannum+"";
                    String phone = rannum+"";
                    String sql = "INSERT INTO public.order (order_no,plate_no,user_name,receiver_name,receiver_phone,plate_color) VALUES ("+rand+", "+plateNo+", '任×××','王五',"+phone+",'蓝');";
                    stmt.executeUpdate(sql);
                    System.out.println(i);
                }
                c.commit();
                long t02 = System.currentTimeMillis();
                System.out.println(t02-t);

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("新增数据成功！");
        }
    }
}
