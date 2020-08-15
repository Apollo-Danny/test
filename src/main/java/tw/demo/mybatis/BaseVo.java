package tw.demo.mybatis;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: BaseVo
 * @Date: 2019/8/5
 * @Time: 3:00 PM
 */
@Data
@NoArgsConstructor
//@NameStyle(Style.camelhumpAndLowercase)
public class BaseVo implements Serializable {


    private String userName;

    private String type = null;



}
