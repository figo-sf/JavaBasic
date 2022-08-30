package com.figo.java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByTest {

  static   List<User> list = User.getUsers();


    public static void main(String[] args) {
       // GroupByTest.groupingByCity();
        //GroupByTest.groupingByString();
        GroupByTest.groupingByList();
        /*System.out.println(LocalDate.now());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(LocalTime.now().format(df));*/
    }

    public static void groupingByCity() {
        Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(User::getAge));

        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }

    public void groupingByCount() {
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.counting()));

        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }

    public static void groupingByString() {
        Map<String, String> map = list.stream().collect(Collectors.groupingBy(User::getName,
                Collectors.mapping(User::getName, Collectors.joining(", ", "Names: [", "]"))));

        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }

    public static void groupingByList() {
        Map<Integer, List<String>> map = list.stream().collect(
                Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));

        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
            v.stream().forEach(item -> {
                System.out.println("item = " + item);
            });
        });
    }

}
