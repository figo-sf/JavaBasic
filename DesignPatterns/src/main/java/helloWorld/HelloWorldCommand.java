package helloWorld;

/**
 * Created by 50245 on 2017/7/16.
 */
public class HelloWorldCommand implements Command {
    private HelloWorldSubject subject;
    public HelloWorldCommand(Subject subject) {
        super();
        this.subject = (HelloWorldSubject)subject;
    }
    @Override
    public void execute() {
        subject.setStr("hello world");
    }
}
