package tw.demo.sun.mapper.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: User
 * @Date: 2020/6/29
 * @Time: 2:03 PM
 */
@Data
@NameStyle(Style.camelhumpAndLowercase)
@Table(name = "user")
public class User {
}
