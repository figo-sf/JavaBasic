package command;

/**
 * Created by 50245 on 2017/7/16.
 */
public class ProcessArray {
    //定义一个each()方法，用于处理数组，
    public void each(int[] target, Command cmd) {
        cmd.process(target);
    }
}
