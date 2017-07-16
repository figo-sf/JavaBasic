package Visitor;

/**
 * Created by 50245 on 2017/7/16.
 */
public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}
