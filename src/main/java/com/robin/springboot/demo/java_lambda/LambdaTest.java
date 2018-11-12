package com.robin.springboot.demo.java_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaTest {

    // 示例1 ： 匿名函数,接口实现
    private static void lambdaTest1() {
        // jdk 1.8 前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread old style");
            }
        }).start();

        // lambda 表达式
        new Thread(() -> System.out.println("Thread lambda style")).start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable old style");
            }
        };

        // 直接调用 run 方法(没开新线程!)
        Runnable r2 = () -> System.out.println("Runnable lambda style");
        r.run();
        r2.run();
    }

    // 基本数组实现
    private static void lambdaTest2() {
        String[] test2 = {"A", "B", "C"};
        List<String> test = Arrays.asList(test2);

        // jdk 1.8 前
        for (String t : test) {
            System.out.println(t);
        }

        System.out.println("lambda functional operation");
        // lambda 表达式  函数操作
        test.forEach((t) -> System.out.println(t));
        System.out.println("lambda double colon operator");
        // jdk 1.8 lambda 表达式 双冒号操作
        test.forEach(System.out::println);
    }

    // 静态接口实现
    private static void lambdaTest3() {
        String[] test3 = {"BB", "AA", "BA", "CA"};
        Arrays.sort(test3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
//        for (int i = 0; i < test3.length; i++) {
//            System.out.println(test3[i]);
//        }
        List test = Arrays.asList(test3);
        test.forEach(n -> System.out.println(n));

        Arrays.sort(test3, (String s1, String s2) -> (s1.compareTo(s2)));
//        for (int i = 0; i < test3.length; i++) {
//            System.out.println(test3[i]);
//        }
        List t = Arrays.asList(test3);
        t.forEach(System.out::println);
    }


    // 参考：https://www.cnblogs.com/franson-2016/p/5593080.html
    // 使用summaryStatistics方法获得stream 中元素的各种汇总数据
    private static void lambdaTest4() {
        List<Integer> numbers = Arrays.asList(1, 7, 8, 9, 2, 3, 4, 5, 6, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }

    // 参考：http://www.importnew.com/16436.html
    // 使用lambda表达式和函数式接口Predicate，过滤集合数据的多种常用方法
    private static void lambdaTest5() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, str -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, str -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        // 用and()、or()和xor()逻辑函数来合并Predicate，达到多条件查询
        System.out.println("多条件查询：");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        filter(languages, startsWithJ.and(fourLetterLong));
    }

    public static void filter(List<String> names, Predicate<String> condition) {

        names.forEach(n -> {
            if (condition.test(n)) System.out.println(n + "");
        });
        System.out.println("-------------");

//        names.stream().filter(n -> (condition.test(n))).forEach(n -> System.out.println(n));
//        System.out.println("=============");

//        for(String name: names)  {
//            if(condition.test(name)) {
//                System.out.println(name + " ");
//            }
//        }
    }

    private static void lambdaTest6(){
//        对列表的每个元素应用函数
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

//        复制不同的值，创建一个子列表,distinct() 方法来对集合进行去重
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
    public static void main(String[] args) {
//        lambdaTest1();
//        lambdaTest2();
//        lambdaTest3();
//        lambdaTest4();
//        lambdaTest5();
        lambdaTest6();
    }

}
