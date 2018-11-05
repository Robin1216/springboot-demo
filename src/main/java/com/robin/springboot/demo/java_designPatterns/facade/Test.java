package com.robin.springboot.demo.java_designPatterns.facade;

public class Test {
    public static void main(String[] args) {
        A a = new AImpl();
        B b1 = new  B1(a);
        B b2 = new B2(a);
        b1.deal();
        b2.deal();
    }
}
