package com.figo.reflect;



import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ReflectDemo {

    public static void main1(String[] args) {
        try {
            Class<?> personClass = Class.forName("com.figo.reflect.Person");
            Object instance = personClass.newInstance();
            Method[] declaredMethods = personClass.getDeclaredMethods();
            for (Method item : declaredMethods) {
                String name = item.getName();
                Type typeClass = item.getGenericReturnType();
                Type[] genericType = item.getGenericParameterTypes();
                if(genericType.length!=0) {
                    System.out.println(name + " 的返回值为 " + typeClass.toString() + ", 参数值为：" +
                            genericType[0].toString());
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws  Exception{
        Person p =new Person(1,"figo",10.0);
        Field[] fields = p.getClass().getDeclaredFields();
        Class<? extends Person> testClass = p.getClass();
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), testClass);
            //获得get方法
            Method getMethod = pd.getReadMethod();
            //执行get方法返回一个Object
            Object obj = getMethod.invoke(p);
            System.out.println(obj.toString());
        }
    }

}

