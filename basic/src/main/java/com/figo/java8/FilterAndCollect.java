package com.figo.java8;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAndCollect {
    public static void main(String[] args) {
        List<User> list = User.getUsers();
        long count = list.stream()
                .filter(u -> u.getName().endsWith("sh"))
                .collect(Collectors.counting());
        System.out.println("Number of users ending name with 'sh': " + count);

        String names = list.stream()
                .filter(u -> u.getName().endsWith("sh"))
                .map(User::getName)
                .collect(Collectors.joining("--"));
        System.out.println("Joining users ending name with 'sh': " + names);
    }
}
