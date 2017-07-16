package factory;

/**
 * Created by 50245 on 2017/7/16.
 */
public class Dog implements Say{
    @Override
    public void Sayhello() {
        System.out.println("Dog!!!!!!");
    }

    @Override
    public void laugh() {
        System.out.println("Wang Wang Wang ");
    }
}
