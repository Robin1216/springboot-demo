package com.robin.springboot.demo.java_date;

import java.util.HashMap;

public class HashMapLinkUtil<K, V> extends HashMap<K, V> {

    private HashMapLinkUtil() {
    }

    public static HashMapLinkUtil newInstance() {
        return new HashMapLinkUtil();
    }

    public HashMapLinkUtil add(K k, V v) {
        this.put(k, v);
        return this;
    }
}
