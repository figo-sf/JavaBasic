import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by 50245 on 2017/9/5.
 */
public class PrototypeTest {

    @Test
    public void test() {
        Robot firstRobot = new Robot("Droid#1");
        Robot secondRobot = null;
        try {
            secondRobot = (Robot) firstRobot.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assertTrue("Cloned robot's instance can't be the same as the"
                        +" source robot instance",
                firstRobot == secondRobot);
        assertTrue("Cloned robot's name should be '"+firstRobot.getName()+"'"
                        +" but was '"+secondRobot.getName()+"'",
                secondRobot.getName().equals(firstRobot.getName()));
    }

}


class Robot implements Cloneable {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
