package com.robin.springboot.demo.java_designPatterns.adapter;

/**
 * 适配器。
 * 采用组合方式：适配器实现调用接口，并创建目标功能的实例对象，在调用方法中调用实例对象的方法（目标功能）。
 */
public class Adapter2 implements A {
    private BImpl bImpl;

    public Adapter2(BImpl bImpl) {
        this.bImpl = bImpl;
    }

    @Override
    public void a() {
        bImpl.b();
    }
}
