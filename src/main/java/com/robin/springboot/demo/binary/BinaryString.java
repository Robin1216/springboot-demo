package com.robin.springboot.demo.binary;

import java.util.Date;

public class BinaryString {
    public static void main(String[] args) {
        Object bSt = "test".getBytes();
       chekSyle(bSt);
    }

    public static String toString(String binary) {
        String[] tempStr = binary.split(",");
        char[] tempChar = new char[tempStr.length];
        for (int i = 0; i < tempStr.length; i++) {
            tempChar[i] = BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }


    //将二进制字符串转换成int数组
    public static int[] BinstrToIntArray(String binStr) {
        char[] temp = binStr.toCharArray();
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i] - 48;
        }
        return result;
    }


    //将二进制转换成字符
    public static char BinstrToChar(String binStr) {
        int[] temp = BinstrToIntArray(binStr);
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[temp.length - 1 - i] << i;
        }
        return (char) sum;
    }

    public static void chekSyle(Object o) {
        if (o instanceof Integer) {
            int value = ((Integer) o).intValue();
            System.out.println("instanceof Integer:" + value);
        } else if (o instanceof String) {
            String s = (String) o;
            System.out.println("instanceof String:" + s);
        } else if (o instanceof Double) {
            double d = ((Double) o).doubleValue();
            System.out.println("instanceof Double:" + d);
        } else if (o instanceof Float) {
            float f = ((Float) o).floatValue();
            System.out.println("instanceof Float:" + f);
        } else if (o instanceof Long) {
            long l = ((Long) o).longValue();
            System.out.println("instanceof Long:" + l);
        } else if (o instanceof Boolean) {
            boolean b = ((Boolean) o).booleanValue();
            System.out.println("instanceof Boolean:" + b);
        } else if (o instanceof Date) {
            Date d = (Date) o;
            System.out.println("instanceof Date:" + d);
        } else {
            isArray(o);
        }
    }

    public static void isArray(Object array) {
        if (array instanceof Object[]) {
            System.out.println("instanceof Object[]:");
        } else if (array instanceof boolean[]) {
            System.out.println("instanceof boolean[]:");
        } else if (array instanceof byte[]) {
            System.out.println("instanceof byte[]:");
        } else if (array instanceof char[]) {
            System.out.println("instanceof char[]:");
        } else if (array instanceof double[]) {
            System.out.println("instanceof double[]:");
        } else if (array instanceof float[]) {
            System.out.println("instanceof float[]:");
        } else if (array instanceof int[]) {
            System.out.println("instanceof int[]:");
        } else if (array instanceof long[]) {
            System.out.println("instanceof long[]:");
        } else if (array instanceof short[]) {
            System.out.println("instanceof short[]:");
        }
    }



}


