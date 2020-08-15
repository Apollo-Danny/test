package tw.demo.mybatis;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: MapperBean
 * @Date: 2019/8/5
 * @Time: 3:02 PM
 */
public class MapperBean {

    public String selectById(String orderNo){
        return "select * from user u inner join issue_order o on u.alipay_user_id = o.alipay_user_id where o.type = " + orderNo;
    }
}
