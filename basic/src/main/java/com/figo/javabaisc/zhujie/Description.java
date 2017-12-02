package com.figo.javabaisc.zhujie;

import java.lang.annotation.*;

/**
 * Created by 50245 on 2017/10/27. 注解例子
 *
 Java Annotation对应的Retention有3种，在RetentionPolicy中定义，有3种：

 SOURCE. 注解保留在源代码中，但是编译的时候会被编译器所丢弃。比如@Override, @SuppressWarnings
 CLASS. 这是默认的policy。注解会被保留在class文件中，但是在运行时期间就不会识别这个注解。
 RUNTIME. 注解会被保留在class文件中，同时运行时期间也会被识别。所以可以使用反射机制获取注解信息。比如@Deprecated

 Target：用于描述注解的使用范围（注解可以用在什么地方）。

 ElementType.CONSTRUCTOR：构造器。
 ElementType.FIELD：成员变量。
 ElementType.LOCAL_VARIABLE：局部变量。
 ElementType.PACKAGE：包。
 ElementType.PARAMETER：参数。
 ElementType.METHOD：方法。
 ElementType.TYPE：类、接口(包括注解类型) 或enum声明。

 Documented：表示该注解会被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。

 Inherited：表示该注解是可被继承的（如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类）。
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String value();
}
