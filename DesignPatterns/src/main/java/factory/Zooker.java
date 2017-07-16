package factory;

/**
 * Created by 50245 on 2017/7/16.
 */
public class Zooker {
    public Say produce(String type) {
        if ("Cat".equals(type)) {
            return new Cat();
        } else if ("Dog".equals(type)) {
            return new Dog();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    public static void main(String[] args) {
        Zooker zooker = new Zooker();
        Say say= zooker.produce("Dog");
        say.laugh();
        say.Sayhello();
    }
}
