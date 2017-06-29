package com.figo.javabaisc.staticTest;

public class StaticTest extends fatherClass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // staticFun();
        // System.out.println(st.var+"&"+st.var2+"&"+staticVar);

        // StaticTest st;

        System.out.println("------------------");

        System.out.println("--StaticTest->main");
        StaticTest st = new StaticTest();

        System.out.println("------------------");
    }

    public StaticTest() {
        System.out.println("StaticTest constructor");
    }

    // 初始化时，可以直接调用静态成员，以及同类的非静态成员

    // 静态变量初始化时不能引用非静态成员
    public static int staticVar = new AssistClass().getNum2();

    public int var = new AssistClass().getNum();

    public int var2 = fun3();

    public static void staticFun() {
        // 静态方法不能直接调用非静态成员
        // 需要：1.实例化 2.改为静态
        // ! fun2();
        System.out.println("sattic method");

    }

    // 静态域与静态变量初始化具有相同的优先级
    static {
        staticVar++;
        System.out.println("static block:" + staticVar);

    }

    public static int staticFun2() {
        System.out.println("static field init staticFun2");
        return 2;
    }


    public static int staticFun3() {
        System.out.println("not static field init staticFun3");
        return 3;
    }

    // 非静态域与非静态变量初始化具有相同的优先级
    {
        System.out.println("not static block StaticTest");

    }


    public void fun() {// 非静态方法可以直接调用静态和非静态成员
        staticVar = 1;
        staticFun();
        fun2();
    }

    public void fun2() {

    }

    public int fun3() {
        return 3;
    }
}
/*
执行StaticTest类的main方法，输出结果：

		father static field init
		father static block
        static field init
        static block
		father not static block
		father not static field init
		not static field init
		not static block
		constructor

		要是改变初始化与域的位置，输出结果也会有相应改变，同样静态(或非静态)的初始化和域，基本按照先后顺序执行。

		结论是：

		1）静态成员不能直接调用非静态成员 ，即
		a）静态变量初始化时不能调用非静态成员
		b） 静态方法不能调用非静态成员
		2）不管位置如何，静态初始化 / 域先于非静态初始化 / 域，父类的初始化 / 域先于子类的初始化 / 域，变量的初始化以及域先于构造方法执行。即：
		a） 先初始化 / 域，后构造方法；
		b） 先“静态”后“非静态”；
		c） 先父后子。
		其他静态 / 非静态方法均需调用才能执行

		这里请注意次序排列的先后顺序，比如静态非静态的区分先于父子类的区分，即子类的静态初始化比父类的非静态初始化优先的。

		3）静态方法在第一次被执行时，会先执行静态的初始化和域，如所属类的main方法，构造方法虽没有static标示符，但也可以认为是静态方法。而在构造方法执行（即实例化）时，除了执行静态初始化和域，接着又会执行非静态的初始化和域。

		当然非静态在每次实例化都会执行一次。

		关于域，那是不归于方法封装的执行代码，即它是可以主动执行（静态在定义时，非静态在实例化时进行）的，而不必通过方法调用，应该有点类似C吧。

		至于静态类，这里没有进行测试，静态类首先是内部类，声明为静态类的内部类在被其他外部类调用时，就不必new了。 */
