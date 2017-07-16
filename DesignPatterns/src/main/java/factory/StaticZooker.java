package factory;

/**
 * Created by 50245 on 2017/7/16.
 */
public class StaticZooker {
    public static Say Carproduce(){
        return new Cat();
    }


    public static Say Dogproduce(){
        return new Dog();
    }

    public static void main(String[] args) {
        Say say = StaticZooker.Carproduce();
        say.Sayhello();
        say.laugh();

    }
}
