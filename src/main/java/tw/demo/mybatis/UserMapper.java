package tw.demo.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: UserMapper
 * @Date: 2019/8/5
 * @Time: 10:29 AM
 */
public interface UserMapper {


    /**
     * @description: TODO
     * @methodName:   
     * @return:  
     * @throws
     * @author:  baixiaobai
     * @date:  2019/8/5 2:30 PM 
     */
    @Insert("insert into user (user_name,user_phone,user_address) values (#{userName},#{userPhone},#{userAddress})")
    int insert(User user);

    @SelectProvider(type = MapperBean.class,method = "selectById")
    List<BaseVo> selectById(String orderNo);




}
