/**
 * Created by 50245 on 2017/8/22.
 */

import com.figo.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;



public class CarTest {


    public static void main(String[] args) {


        //classPathResourceTest();

        classPathXmlApplicationContextTest();


    }

    public static  void classPathResourceTest(){
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:applicationContext.xml");
        // BeanFactory
       // Resource cr = new ClassPathResource("applicationContext.xml");
        @SuppressWarnings("deprecation")
        BeanFactory bf = new XmlBeanFactory(res);
        Car car = bf.getBean("car", Car.class);
        System.out.println(car.toString());
    }

    public static void classPathXmlApplicationContextTest(){
        // ApplicationContext
        @SuppressWarnings("resource")
       // ApplicationContext factory=new FileSystemXmlApplicationContext("resources/applicationContext.xml");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Car car = context.getBean("car" ,Car.class);
       System.out.println(car);


    }


}
