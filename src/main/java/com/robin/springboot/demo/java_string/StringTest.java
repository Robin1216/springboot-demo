package com.robin.springboot.demo.java_string;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silkNets
 * @since: 2019/1/21 18:14
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
//        String test  = "\n\n\n\t";
//        String test = ".";
//        excludeStrList.add(".");

//        System.out.println(test);
////        System.out.println(StringUtils.isEmpty(test));
//        System.out.println("" + (StringUtils.isBlank(test) || isExcludeStr(test)));
//        String s = "深圳市";
//        String s = "深圳市深圳市";
        String s = "shen zhen shi";
        System.out.println(deleteLastStr(s,"shi"));
    }

    private static List<String> excludeStrList = new ArrayList<>();

    /**
     * 是否是需要过滤的字符串
     *
     * @param test 要检验的字符串
     * @return true 是，false 否
     */
    public static boolean isExcludeStr(String test) {
        for (String s : excludeStrList) {
            if (s.equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }

    // 将字符串的中最后一个匹配的字符串去掉
    private static String deleteLastStr(String name, String lastStr) {
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(lastStr)) {
            int indexOfDeleteStr = name.lastIndexOf(lastStr);
            int lengthOfDeleteStr = lastStr.length();
            int length = name.length();

            if (indexOfDeleteStr == length - lengthOfDeleteStr) {
                name = name.substring(0, indexOfDeleteStr).trim();
            }
        }
        return name;
    }



}
