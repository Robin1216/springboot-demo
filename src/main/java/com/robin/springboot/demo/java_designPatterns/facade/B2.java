package com.robin.springboot.demo.java_designPatterns.facade;

/**
 * 具体的装饰实现类 2
 */
public class B2 extends B {
    B2(A a) {
        super(a);
    }

    @Override
    public void deal() {
//        super.deal();
        System.out.println("具体装饰类 2 执行了");
    }
}
