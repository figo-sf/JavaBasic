package Interpreter;

/**
 * Created by 50245 on 2017/7/16.
 */
public class Plus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}