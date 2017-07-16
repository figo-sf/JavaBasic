package Visitor;

/**
 * Created by 50245 on 2017/7/16.
 */
public class MyVisitor implements Visitor {

    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject："+sub.getSubject());
    }
}