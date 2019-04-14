package com.robin.springboot.demo.java_lambda;

import com.robin.springboot.demo.java_random.BigDecimalUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author: silkNets
 * @since: 2019/1/24 10:33
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        for(int i = 0; i < 10 ; i++){

            DecimalFormat df=new DecimalFormat("0.0000");
            BigDecimal amount = getRandom(0.66,2.66);
            System.out.println(amount);
            System.out.println(df.format(amount));
            System.out.println();
        }
    }
    /*
     * 获取[min,max]范围内的随机数；min 、max，取小数点后两位，之后的舍去；返回值保留小数点后两位
     */
    public static BigDecimal getRandom(double min, double max) {

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
