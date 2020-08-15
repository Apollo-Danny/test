package tw.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Application02
 * @Date: 2020/8/12
 * @Time: 11:43 PM
 */
@Component
public class Application02 implements ApplicationListener<Application01> {
    @Override
    public void onApplicationEvent(Application01 application01) {
        System.out.println("时间执行了======="+JSON.toJSONString((Demo03)application01.getSource()));
    }
}
