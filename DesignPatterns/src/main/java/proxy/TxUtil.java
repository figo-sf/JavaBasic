package proxy;

/**
 * Created by 50245 on 2017/7/16.
 */

public class TxUtil {
    //第一个拦截器方法:模拟事务开始
    public void beginTx() {
        System.out.println("=====模拟开始事务=====");
    }

    //第二个拦截器方法:模拟事务结束
    public void endTx() {
        System.out.println("=====模拟结束事务=====");
    }
}
