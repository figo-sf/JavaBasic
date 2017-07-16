package Bridge;

/**
 * Created by 50245 on 2017/7/16.
 */
public class PorkyNoodle extends AbstractNoodle {
    public PorkyNoodle(Peppery style) {
        super(style);
    }

    //实现eat()抽象方法
    public void eat() {
        System.out.println("这是一碗稍嫌油腻的猪肉面条。"
                + super.style.style());
    }
}
