package tw.demo.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * @description: mybatis配置
 * @author: baixiaobai
 * @className: MyBatisMapperScannerConfig
 * @Date: 2019/8/9
 * @Time: 10:37 AM
 */
@Configuration
public class MyBatisMapperScannerConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		// 扫描该路径下的dao
		mapperScannerConfigurer.setBasePackage("tw.demo");
		Properties properties = new Properties();
		// 通用mapper
		properties.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "MYSQL");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}

}
