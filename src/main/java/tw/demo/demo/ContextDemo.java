package tw.demo.demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: ContextDemo
 * @Date: 2020/7/23
 * @Time: 10:55 AM
 */
public class ContextDemo {

    private Demo01 demo01;

    public ContextDemo(Demo01 demo01){
        this.demo01 = demo01;
    }

    public void getContextMethod(){
        demo01.getMethod();
    }
}
