package com.robin.springboot.demo.java_designPatterns.adapter;

/**
 *  目标功能的实现类
 */
public class BImpl implements B {
    @Override
    public void b() {
        System.out.println("B.b() 被执行了...");
    }
}
