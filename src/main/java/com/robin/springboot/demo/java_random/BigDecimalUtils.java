package com.robin.springboot.demo.java_random;

import java.math.BigDecimal;

/**
 * BigDecimal工具类
 *
 * @author jimmy
 */
public class BigDecimalUtils {

    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(double value1, double value2) {

        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
        BigDecimal b2 = new BigDecimal(String.valueOf(value2));

        return setScale(b1.add(b2), 2);
    }

    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(String value1, String value2) {

        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);

        return setScale(b1.add(b2), 2);
    }

    public static BigDecimal add(String value, String... values) {

        BigDecimal b1 = new BigDecimal(value);
        for (String val : values) {
            b1 = b1.add(new BigDecimal(val));
        }

        return setScale(b1, 2);
    }

    public static BigDecimal add(double value, double... values) {

        BigDecimal b1 = new BigDecimal(String.valueOf(value));
        for (double val : values) {
            b1 = b1.add(new BigDecimal(String.valueOf(val)));
        }

        return setScale(b1, 2);
    }

    public static BigDecimal addBigDecimal(BigDecimal bigDecimal, double... values) {

        BigDecimal bd = new BigDecimal(String.valueOf(setScale(bigDecimal, 2)));
        for (double val : values) {
            bd = bd.add(new BigDecimal(String.valueOf(val)));
        }

        return setScale(bd, 2);
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 减数
     * @param value2 被减数
     * @return 两个参数的差
     */
    public static BigDecimal sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
        BigDecimal b2 = new BigDecimal(String.valueOf(value2));
        return setScale(b1.subtract(b2), 2);
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 乘数
     * @param value2 被乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(value1));
        BigDecimal b2 = new BigDecimal(String.valueOf(value2));
        return setScale(b1.multiply(b2), 2);
    }

    /**
     * 提供精确除法运算的divide方法
     *
     * @param value1 除数
     * @param value2 被除数
     * @return
     */
    public static BigDecimal divide(BigDecimal value1, int value2) {
        BigDecimal val = new BigDecimal(value2);
        return setScale(value1.divide(val), 2);
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 乘数
     * @param value2 被乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(BigDecimal value1, int value2) {

        BigDecimal val = new BigDecimal(value2);

        return value1.multiply(val);
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 乘数
     * @param value2 被乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(BigDecimal value1, double value2) {

        BigDecimal val = new BigDecimal(String.valueOf(value2));

        return value1.multiply(val);
    }

    /**
     * 精确到2位小数
     *
     * @param bigDecimal
     * @param scale
     * @return
     */
    public static BigDecimal setScale(BigDecimal bigDecimal, int scale) {

        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    public static double getDouble(double value) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));
        return setScale(bigDecimal, 2).doubleValue();
    }

    public static BigDecimal getBigDecimal(double value) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));
        return setScale(bigDecimal, 2);
    }

    public static BigDecimal getBigDecimal(String value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return setScale(bigDecimal, 2);
    }

    public static void main(String[] args) {
        double value1 = 10.741d;
        double value2 = 20.561d;
        double value3 = 20.567434d;
		/*double value4 = 20.567434d;
		System.out.println(add(value1, value2));
		System.out.println(sub(value1, value2));
		System.out.println(mul(value1, value2));
		System.out.println(add(value1, value2, value3, value4));*/
        BigDecimal bigDecimal = new BigDecimal("0");
        for (int i = 0; i < 3; i++) {
            bigDecimal = BigDecimalUtils.addBigDecimal(bigDecimal, value1, value2, value3);
            System.out.println(bigDecimal.doubleValue());
        }

    }
}
