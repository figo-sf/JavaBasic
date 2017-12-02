package com.figo.javabaisc.funciton;

/**
 * Created by 50245 on 2017/10/27.
 */
public class Fibolaqie {
    // 使用递归方法
    private static int getFibo(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            //return 一定要有
            return getFibo(i - 1) + getFibo(i - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println("斐波那契数列的前20项为：");
        for (int j = 1; j <= 20; j++) {
            System.out.print(getFibo(j) + "\t");
            if (j % 5 == 0)
                System.out.println();
        }
    }

}
