package helloWorld;

/**
 * Created by 50245 on 2017/7/16.
 */
public class AbuseDesignPatterns {
    public static void main(String[] args) {
        AbstractFactory factory = FactoryMakerSingleton.getInstance().getFactory();
        Subject subject = factory.createSubject();
        subject.attach(factory.createObserver());
        Command command = factory.createCommand(subject);
        command.execute();
    }
}
