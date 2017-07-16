package factory;

/**
 * Created by 50245 on 2017/7/16.
 */
public class DogFactory implements  Provider{
    @Override
    public Say produce() {
        return new Dog();
    }
}
