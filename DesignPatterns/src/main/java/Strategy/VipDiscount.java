package Strategy;

/**
 * Created by 50245 on 2017/7/16.
 */

//实现DiscountStrategy接口，实现对VIP打折的算法
public class VipDiscount implements DiscountStrategy {
    // 重写getDiscount()方法，提供VIP打折算法
    public double getDiscount(double originPrice) {
        System.out.println("使用VIP折扣...");
        return originPrice * 0.5;
    }
}
