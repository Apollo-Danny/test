package tw.demo.mybatis;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: User
 * @Date: 2019/8/5
 * @Time: 10:30 AM
 */
@Data
//@NameStyle(Style.camelhumpAndLowercase)
@Table(name = "user")
public class User {


    @Id
    private int id;
    @Column(name = "user_name")
    private String user_name = null;
    @Column(name = "user_phone")
    private String userPhone = null;
    @Column(name = "user_address")
    private  String userAddress = null;
    @Column(name = "alipay_user_id")
    private  String alipayUserId = null;
}
