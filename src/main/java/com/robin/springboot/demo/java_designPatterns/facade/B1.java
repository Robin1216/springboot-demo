package com.robin.springboot.demo.java_designPatterns.facade;

/**
 * 具体的装饰类
 */
public class B1 extends B {

    B1(A a) {
        super(a);
    }

    @Override
    public void deal() {
        //super.deal();
        System.out.println("具体装饰类 1 执行了");
    }


}
