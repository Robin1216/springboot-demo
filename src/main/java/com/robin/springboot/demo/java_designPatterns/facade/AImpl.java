package com.robin.springboot.demo.java_designPatterns.facade;

/**
 * 被装饰的类
 */
public class AImpl implements A {
    @Override
    public void deal() {
        System.out.println("需要被装饰的类");
    }
}
