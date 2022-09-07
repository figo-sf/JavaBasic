package com.figo.java8.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8PredicateTest {
    public static void main(String[] args) {
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test(""));
        System.out.println(isEmpty.test("www.wdbyte.com"));


        //filter();
        //and();
        //neagete();
        chain();
    }

    public static void filter() {
        List<String> list = Arrays.asList("java", "node", "www.wdbyte.com");
        list = list.stream().filter(str -> str.length() == 4).collect(Collectors.toList());
        System.out.println(list);
    }


    public static void and() {
        List<Integer> numberList = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> greaterThan5 = number -> number > 5;
        Predicate<Integer> lessThan9 = number -> number < 9;
        Predicate<Integer> filter = greaterThan5.and(lessThan9);

        numberList = numberList.stream().filter(filter).collect(Collectors.toList());
        System.out.println(numberList);
    }

    public static void neagete() {
        List<Integer> numberList = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> greaterThan5 = number -> number > 5;

        numberList = numberList.stream().filter(greaterThan5.negate()).collect(Collectors.toList());
        System.out.println(numberList);
    }
    public static void chain() {
        List<Integer> numberList = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> lessThan5 = number -> number <= 5;
        Predicate<Integer> greaterThan9 = number -> number >= 9;

        // 小于等于 5
        System.out.println(filter(numberList, lessThan5));
        // 大于 5
        System.out.println(filter(numberList, lessThan5.negate()));
        // 小于等于 5 或者大于等于 9
        System.out.println(filter(numberList, lessThan5.or(greaterThan9)));
        // ! (小于等于 5 AND 大于等于 9)
        System.out.println(filter(numberList, lessThan5.or(greaterThan9).negate()));
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                resultList.add(t);
            }
        }
        return resultList;
    }
}
