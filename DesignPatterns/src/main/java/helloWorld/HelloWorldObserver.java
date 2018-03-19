package helloWorld;

/**
 * Created by 50245 on 2017/7/16.
 */
public class HelloWorldObserver implements Observer {
    @Override
    public void update(Subject subject) {
        HelloWorldSubject sub = (HelloWorldSubject)subject;
        System.out.println(sub.getStr());
    }
}