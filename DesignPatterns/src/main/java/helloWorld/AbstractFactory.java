package helloWorld;

/**
 * Created by 50245 on 2017/7/16.
 */
public interface  AbstractFactory {
    public Subject createSubject();
    public Observer createObserver();
    public Command createCommand(Subject subject);
}
