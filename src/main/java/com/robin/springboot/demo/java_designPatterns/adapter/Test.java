package com.robin.springboot.demo.java_designPatterns.adapter;

public class Test {
    public static void main(String[] args) {
       /*
       目标功能实现类不用变动，采用 继承 方式更合理
        */
        A a1 = new Adapter1();
        a1.a();

        /*
        需要动态修改实现类，则采用 组合 方式更适合
         */
        A a2 = new Adapter2(new BImpl());
        a2.a();

        /*
        目标功能接口有多个方法，但只需要实现其中少数的方法
         */
        A a3 =new Adapter3Sub();
        a3.a();
    }
}
