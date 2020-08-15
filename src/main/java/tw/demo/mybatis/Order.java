package tw.demo.mybatis;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Order
 * @Date: 2019/8/5
 * @Time: 2:57 PM
 */
@Data
public class Order<T> {

    private Boolean orderNo;

    private String alipayUserId = null;

    private T data;

}
