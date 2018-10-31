package com.robin.springboot.demo.java_designPatterns.adapter;

/**
 * 适配器。
 * 采用继承方式： 适配器继承目标功能接口实现类，再实现调用接口，在调用接口实现方法中调用 目标方法。
 */
public class Adapter1 extends BImpl implements A{
    @Override
    public void a() {
        b();
    }
}
