package proxy;

/**
 * Created by 50245 on 2017/7/16.
 */
public class ProxyTest {
    public static void main(String[] args)
            throws Exception
    {
        //创建一个原始的GunDog对象，作为target
        Panther target = new GunPanther();
        //以指定的target来创建动态代理
        Panther panther = (Panther)MyProxyFactory.getProxy(target);
        //调用代理对象的info()和run()方法
        panther.info();
        panther.run();
    }
}
