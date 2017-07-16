package singleton;

/**
 * Created by 50245 on 2017/7/16.
 */
public class SingletonTest {

    private static SingletonTest instance = null;

    /* 私有构造方法，防止被实例化 */
    private SingletonTest() {
    }

    /*在第一次调用的时候使用互斥机制*/
    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new SingletonTest();
        }
    }

    /* 获取实例 */
    public static SingletonTest getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
    /**
     * synchronized关键字锁定的是对象，在用的时候，一定要在恰当的地方使用（注意需要使用锁的对象和过程，可能有的时候并不是整个对象及整个过程都需要锁）
     */
}
