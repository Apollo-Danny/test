package tw.demo.annotation;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Person
 * @Date: 2019/7/9
 * @Time: 下午4:54
 */
@Data
public class Person {

    @ValidateParameter(value = "姓名")
    private String name;
    @ValidateParameter(value = "年龄")
    private String age;
}
