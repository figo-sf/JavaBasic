package Strategy;

/**
 * Created by 50245 on 2017/7/16.
 */
public interface DiscountStrategy {
    //定义一个用于计算打折价的方法
    double getDiscount(double originPrice);
}
