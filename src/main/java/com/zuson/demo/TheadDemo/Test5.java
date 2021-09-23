package com.zuson.demo.TheadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 写一个固定容器同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 */
public class Test5 {

    volatile Map<String,Object> map = new ConcurrentHashMap<>();

    public void put(String key,Object o){
        map.put(key,o);

    }

    public Map<String,Object> get(){
        return map;
    }


}
