package tw.demo.annotation;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: MyAnnotation
 * @Date: 2019/7/9
 * @Time: 下午4:52
 */
public class MyAnnotation {

    public static <T> List<ValidateResult> validate(T t){
        List<ValidateResult> validateResults = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.isAnnotationPresent(ValidateParameter.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                for (Class<?> group : field.getAnnotation(ValidateParameter.class).groups()) {

                }
                if (value==null) {
                    ValidateParameter notNull = field.getAnnotation(ValidateParameter.class);
                    ValidateResult validateResult = new ValidateResult();
                    validateResult.setMessage(notNull.value()+"不能为空");
                    validateResults.add(validateResult);
                }
            }

        }
        return validateResults;
    }

    public static <T> List<ValidateResult> validateForClass(T t,Class<?> groupClass){
        List<ValidateResult> validateResults = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.isAnnotationPresent(ValidateParameter.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                for (Class<?> group : field.getAnnotation(ValidateParameter.class).groups()) {

                    if (!group.isAssignableFrom(groupClass)) {
                        continue;
                    }
                    if (value==null) {
                        ValidateParameter notNull = field.getAnnotation(ValidateParameter.class);
                        ValidateResult validateResult = new ValidateResult();
                        validateResult.setMessage(notNull.value()+"不能为空");
                        validateResults.add(validateResult);
                    }
                }
            }

        }
        return validateResults;
    }
}
