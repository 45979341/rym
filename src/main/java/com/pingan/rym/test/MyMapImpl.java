package com.pingan.rym.test;

/**
 * @author 刘欣武
 * @version $Id: MyMapImpl, v 0.1 2019/7/24 10:44 刘欣武 Exp$
 */
public class MyMapImpl<K,V> implements MyMap<K,V> {

    private K key;
    private V value;

    public MyMapImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }


    public static void main(String[] args){
        MyMap<String, Integer> mp1= new MyMapImpl<>("Even", 8);
        MyMap<String, String>  mp2= new MyMapImpl<>("hello", "world");
        MyMap<Integer, Integer> mp3= new MyMapImpl<>(888, 888);
    }
}


