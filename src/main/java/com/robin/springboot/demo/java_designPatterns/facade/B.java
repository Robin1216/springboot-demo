package com.robin.springboot.demo.java_designPatterns.facade;

/**
 * 装饰的基类
 */
public class B implements A {

    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void deal() {
        a.deal();
    }
}
