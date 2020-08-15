package tw.demo.demo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Demo03
 * @Date: 2020/7/23
 * @Time: 10:55 AM
 */
@Data
public class Demo03 implements Demo01 {

    private String name;
    @Override
    public String getMethod() {
        System.out.println("222");
        return null;
    }
}
