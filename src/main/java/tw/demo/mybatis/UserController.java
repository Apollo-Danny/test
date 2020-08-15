package tw.demo.mybatis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: UserController
 * @Date: 2019/8/5
 * @Time: 10:26 AM
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{userName}")
    public String userInsert(@PathVariable("userName") String userName){
        User user = new User();
        user.setUser_name(userName);
        user.setUserAddress("北京市朝阳区");
        user.setUserPhone("12345435");
        return userService.insert(user)+"";
    }

//    @GetMapping("/")
//    public String userSelect(){
//        List select = userService.select();
//        System.out.println(select.get(0));
//        return "";
//    }
    /**
     * @description: TODO
     * @methodName:
     * @return:
     * @throws
     * @author:  baixiaobai
     * @date:  2019/8/5 3:14 PM
     */
    @GetMapping("/order/{orderNo}")
    public String orderSelect(@PathVariable("orderNo")String orderNo){
        List<BaseVo> baseVo = userService.selectById(orderNo);
        System.out.println(JSONObject.toJSONString(baseVo.get(0)));
        return "";
    }
}
