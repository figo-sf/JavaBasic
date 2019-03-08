package com.figo;

/**
 * @Auther: figo sffchxd@qq.comorg.gjt.jclasslib
 * @Date: 2019/1/8 16:57
 * @Description: //todo
 */

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.FileInputStream;

public class Test {
    public static void main(String[] args) {
        try {
            changeMethod();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(1111);
        }
//        String filePath = "D:\\a.class";
//        FileInputStream fis = new FileInputStream(filePath);
//
//        DataInput di = new DataInputStream(fis);
//        ClassFile cf = new ClassFile();
//        cf.read(di);
//        MethodInfo[] methodInfo=cf.getMethods();
//        MethodInfo methodInfo1=methodInfo[33];
//        AttributeInfo attributeInfo=  methodInfo1.getAttributes()[0];
//        fis.close();
//        File f = new File(filePath);
//        ClassFileWriter.writeToFile(f, cf);
    }

    static void changeMethod() throws Exception {
        String filePath = "D:\\FineReportVocer.class";
        FileInputStream fis = new FileInputStream(filePath);
        ClassPool pool = ClassPool.getDefault();
        //设置目标类的路径
        pool.makeClass(fis);
        //获得要修改的类
        CtClass cc = pool.get("org.jeecgframework.web.report.FineReportVocer");//就是对Login.class的映射
        //得到方法
        CtMethod[] mm = cc.getMethods();
        CtMethod m = cc.getDeclaredMethod("isAlphanumeric", new CtClass[]{});
       // CtMethod m2 = cc.getDeclaredMethod("isNotEmpt", new CtClass[]{});
//        //可以在函数的开头插入新的代码
        System.out.println(m.getLongName());
        System.out.println(m.getName());
        m.setBody("{}");
//        m2.setBody("{}");

//        //也可以直接将verify函数的内容设为return true;至于功能你懂的
//        m.setBody("{return true;}");
//        //保存到文件里,会在项目根目录下生成一个Login.class,并没有自动替换classes/Login.class，需要自己手动替换进去

        cc.writeFile();
        fis.close();

    }
}