package tw.demo;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Application01
 * @Date: 2020/8/12
 * @Time: 11:43 PM
 */
public class Application01 extends ApplicationEvent {

//    private String name;
    public Application01(Object source) {
        super(source);
    }
}
