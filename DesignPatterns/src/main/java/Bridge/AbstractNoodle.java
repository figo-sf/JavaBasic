package Bridge;

/**
 * Created by 50245 on 2017/7/16.
 */
public abstract class AbstractNoodle {
    //组合一个Peppery变量，用于将该维度的变化独立出来
    protected Peppery style;

    //每份Noodle必须组合一个Peppery对象
    public AbstractNoodle(Peppery style) {
        this.style = style;
    }

    public abstract void eat();
}
