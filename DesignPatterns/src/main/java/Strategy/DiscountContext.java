package Strategy;

/**
 * 策略模式用于封装系列的算法，这些算法通常被封装在一个被称为Context的类中，
 * 客户端程序可以自由选择其中一种算法，
 * 或让Context为客户端选择一种最佳算法——使用策略模式的优势是为了支持算法的自由切换。
 */

public class DiscountContext {
    //组合一个DiscountStrategy对象
    private DiscountStrategy strategy;

    //构造器，传入一个DiscountStrategy对象
    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    //根据实际所使用的DiscountStrategy对象得到折扣价
    public double getDiscountPrice(double price) {
        //如果strategy为null，系统自动选择OldDiscount类
        if (strategy == null) {
            strategy = new OldDiscount();
        }
        return this.strategy.getDiscount(price);
    }

    //提供切换算法的方法
    public void setDiscount(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args)
    {
        //客户端没有选择打折策略类
        DiscountContext dc = new DiscountContext(null);
        double price1 = 79;
        //使用默认的打折策略
        System.out.println("79元的书默认打折后的价格是："
                + dc.getDiscountPrice(price1));
        //客户端选择合适的VIP打折策略
        dc.setDiscount(new VipDiscount());
        double price2 = 89;
        //使用VIP打折得到打折价格
        System.out.println("89元的书对VIP用户的价格是："
                + dc.getDiscountPrice(price2));
    }
}
