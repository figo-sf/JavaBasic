package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 50245 on 2017/7/16.
 */
public class MyInvokationHandler implements InvocationHandler {
    //需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Exception {
        TxUtil tx = new TxUtil();
        //执行TxUtil对象中的beginTx。
        tx.beginTx();
        //以target作为主调来执行method方法
        Object result = method.invoke(target, args);
        //执行TxUtil对象中的endTx。
        tx.endTx();
        return result;
    }
}
