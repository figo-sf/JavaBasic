package helloWorld;

/**
 * Created by 50245 on 2017/7/16.
 */
public class HelloWorldFactory implements AbstractFactory{
    public Subject createSubject() {
        return new HelloWorldSubject();
    }

    public Observer createObserver() {
        return new HelloWorldObserver();
    }

    public Command createCommand(Subject subject) {
        return new HelloWorldCommand(subject);
    }
}
