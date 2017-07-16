package factory;

/**
 * Created by 50245 on 2017/7/16.
 */
public class AbstractZooker {
    public static void main(String[] args) {
        Provider provider = new DogFactory();
        provider.produce().laugh();
        provider.produce().Sayhello();
    }
}
