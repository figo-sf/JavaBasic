import com.figo.Car;
import com.figo.event.EmailEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Title: Spring的ApplicationContexet单元成测试
 * Description: dataPlatfrom
 * @author: xg.chen
 * @date:2016年8月24日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@ActiveProfiles("dev")
public class EmailEventTest{
    @Autowired
    private  ApplicationContext applicationContext;
    @Autowired
    private Car lining;
    @Test
    public  void mainTest(){
        //读取Spring容器的配置文件
       // @SuppressWarnings("resource")
       // ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建一个事件对象
        EmailEvent emailEvent = new EmailEvent("hello Spring!", "cxg@126.com", "This is SpringApplicatoinContext test!");
        //主动触发事件监视机制
        applicationContext.publishEvent(emailEvent);
        System.out.println(lining.toString());
    }
}