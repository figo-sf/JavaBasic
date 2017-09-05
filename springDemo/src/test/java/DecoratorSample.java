import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by 50245 on 2017/9/5.
 */
public class DecoratorSample {

    @Test
    public void test() {
        Coffee sugarMilkCoffee=new MilkDecorator(new SugarDecorator(new BlackCoffee()));
        assertEquals(sugarMilkCoffee.getPrice(), 6d, 0d);
    }
}

// decorated
abstract class Coffee{
    protected int candied=0;
    protected double price=2d;
    public abstract int makeMoreCandied();
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price+=price;
    }
}
class BlackCoffee extends Coffee{
    @Override
    public int makeMoreCandied(){
        return 0;
    }
    @Override
    public double getPrice(){
        return this.price;
    }
}

// abstract decorator
abstract class CoffeeDecorator extends Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }
    @Override
    public double getPrice(){
        return this.coffee.getPrice();
    }
    @Override
    public int makeMoreCandied(){
        return this.coffee.makeMoreCandied();
    }
}

// concrete decorators
class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public double getPrice(){
        return super.getPrice()+1d;
    }
    @Override
    public int makeMoreCandied(){
        return super.makeMoreCandied()+1;
    }
}
class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public double getPrice(){
        return super.getPrice()+3d;
    }
    @Override
    public int makeMoreCandied(){
        return super.makeMoreCandied()+1;
    }
}
