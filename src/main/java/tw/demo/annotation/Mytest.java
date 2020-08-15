package tw.demo.annotation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Mytest
 * @Date: 2019/7/9
 * @Time: 下午4:55
 */
public class Mytest {

    public static void main(String[] args) {
        Person person = new Person();
//        person.setName("张飞");
        person.setAge("128");
        List<ValidateResult> validate = MyAnnotation.validate(person);
        StringBuilder str = new StringBuilder();
        for (ValidateResult va : validate) {
            if (!va.isValid()) {
                str.append(va.getMessage()).append(",");
            }
        }
        System.err.println(str.toString());
    }
}
