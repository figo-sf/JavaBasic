package Builder;

import factory.Cat;
import factory.Dog;
import factory.Say;

import java.util.ArrayList;
import java.util.List;

/**
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象
 */
public class Builder {
    private List<Say> list = new ArrayList<Say>();

    public void produceCat(int count){
        for(int i=0; i<count; i++){
            list.add(new Cat());
        }
    }

    public void produceDog(int count){
        for(int i=0; i<count; i++){
            list.add(new Dog());
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceCat(10);//10只猫
    }
}
