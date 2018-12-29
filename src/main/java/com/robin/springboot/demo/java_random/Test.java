package com.robin.springboot.demo.java_random;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        for(int i = 0; i < 100; i++){
//            BigDecimal a = getRandom(0.31, 0.71);
//            System.out.println(a);
//        }
        System.out.println(new Date(1545119611761L));
//        System.out.println(new BigDecimal("0.03").setScale(2, BigDecimal.ROUND_DOWN));
    }

    private static void test(){
        double d = 5.333;
        int b = (int) Math.ceil(d);
        System.out.println( b);

        int a = (int) Math.floor(d);
        System.out.println( a);

        System.out.println((int) 2.999999999);
    }

    private static BigDecimal getRandom(double min, double max) {
        if (min == max) {
            return new BigDecimal(String.valueOf(min)).setScale(2, BigDecimal.ROUND_DOWN);
        }
        int minInt = (int) (min * 100);
        int maxInt = (int) (max * 100);
        Random random = new Random();
        int result = random.nextInt(maxInt - minInt + 1) + minInt;
        return BigDecimalUtils.mul(result, 0.01);
    }
}
