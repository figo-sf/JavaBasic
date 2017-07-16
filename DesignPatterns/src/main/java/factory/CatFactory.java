package factory;

/**
 * Created by 50245 on 2017/7/16.
 */
public class CatFactory implements  Provider {
    @Override
    public Say produce() {
        return new Cat();
    }
}
