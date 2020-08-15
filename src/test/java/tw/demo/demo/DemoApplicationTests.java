package tw.demo.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import tw.demo.Application01;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {



	@Autowired
    ApplicationContext applicationContext;

	@Test
	public void test01 (){
        Demo03 demo03 = new Demo03();
        demo03.setName("你好");
        applicationContext.publishEvent(new Application01(demo03));
	}

}
