package Bridge;

/**
 * Created by 50245 on 2017/7/16.
 */
public class BeefMoodle extends AbstractNoodle {
    public BeefMoodle(Peppery style) {
        super(style);
    }

    //实现eat()抽象方法
    public void eat() {
        System.out.println("这是一碗美味的牛肉面条。"
                + super.style.style());
    }
}
