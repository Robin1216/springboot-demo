package com.robin.springboot.demo.java_designPatterns.adapter;

/**
 * 适配器。
 * 采用抽象方法：适配器实现调用接口，并创建目标功能的实例对象，在调用方法中调用实例对象的方法（目标功能）。
 */
public class Adapter3Sub extends Adapter3 implements  A{

    @Override
    public void b() {
        System.out.println("B2.b() 被执行了...");
    }

    @Override
    public void a() {
        b();
    }
}
