package tw.demo.annotation;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: ValidateResult
 * @Date: 2019/7/9
 * @Time: 下午4:48
 */
@Data
public class ValidateResult {

    private boolean isValid = false;
    private String message;

    public boolean isValid(){
        return this.isValid;
    }
}
