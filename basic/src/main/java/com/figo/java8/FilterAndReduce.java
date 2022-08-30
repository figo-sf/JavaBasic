package com.figo.java8;

import java.util.List;
public class FilterAndReduce {
    public static void main(String[] args) {
        List<User> list = User.getUsers();
        list.stream().filter(u -> u.getName().endsWith("sh"))
                .map(u -> u.getName())
                .reduce((a, b) -> a +"-"+ b)
                .ifPresent(s -> System.out.println("Join users ending name with 'sh': "+ s));

        list.stream().filter(u -> u.getName().endsWith("sh"))
                .mapToInt(u -> u.getAge()).reduce((a, b) -> a + b)
                .ifPresent(s -> System.out.println("Sum of age of users ending name with 'sh': "+ s));
    }
}

