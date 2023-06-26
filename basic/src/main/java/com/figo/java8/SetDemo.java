package com.figo.java8;

import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        SortedSet<User> ages = new TreeSet<User>();
        User u= new User(1,"figo",15);
        User u2= new User(2,"figo2",25);
        User u3= new User(3,"figo3",35);
        ages.add(u);
        ages.add(u2);
        ages.add(u3);

        System.out.println("遍历集合中的元素：");
        for (User user : ages) {
            System.out.println(user.getName() + " age:"+user.getAge());
        }
        ages.first().setAge(5);
        System.out.println("遍历集合中的元素：");
        for (User user : ages) {
            System.out.println(user.getName() + " age:"+user.getAge());
        }
    }

}
