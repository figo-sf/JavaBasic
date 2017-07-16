package factory;

/**
 * Created by 50245 on 2017/7/16.
 */
public class Cat  implements Say{
    @Override
    public void Sayhello() {
        System.out.println("Cat!!!!!!");
    }

    @Override
    public void laugh() {
        System.out.println("miao miao");
    }
}
