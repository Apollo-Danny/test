package tw.demo.mybatis;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: service
 * @Date: 2019/8/5
 * @Time: 10:29 AM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int insert(User user){
        return userMapper.insert(user);
    }

//    public List select (){
//        return userMapper.selectAll();
//    }

    public List<BaseVo> selectById(String orderNo){
        return userMapper.selectById(orderNo);
    }
}



