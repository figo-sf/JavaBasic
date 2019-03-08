import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: figo sffchxd@qq.com
 * @Date: 2018/8/9 15:22
 * @Description: //todo
 */
public class JpushClientUtilTest {

    JpushClientUtil jpushClientUtil;
    @Before
    public void setUp() throws Exception {
        jpushClientUtil= new JpushClientUtil();
    }
;
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sendToRegistrationId() throws Exception {

    }

    @Test
    public void sendToAllAndroid() throws Exception {
        jpushClientUtil.sendToAllAndroid("","bbbbbbbbbbbb","bbbbbbbbbb","");
    }

    @Test
    public void sendToAllIos() throws Exception {
    }

    @Test
    public void sendToAll() throws Exception {
    }

    @Test
    public void buildPushObject_android_and_ios() throws Exception {
    }

}