package Visitor;

/**
 * Created by 50245 on 2017/7/16.
 */
public class Test {

    public static void main(String[] args) {

        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}
