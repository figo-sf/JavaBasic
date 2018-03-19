package helloWorld;

/**
 * Created by 50245 on 2017/7/16.
 */
public class HelloWorldFactory implements AbstractFactory{
    @Override
    public Subject createSubject() {
        return new HelloWorldSubject();
    }

    @Override
    public Observer createObserver() {
        return new HelloWorldObserver();
    }

    @Override
    public Command createCommand(Subject subject) {
        return new HelloWorldCommand(subject);
    }
}
