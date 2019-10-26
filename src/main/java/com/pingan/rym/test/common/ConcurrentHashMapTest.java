package com.pingan.rym.test.common;

import com.pingan.rym.utils.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: ConcurrentHashMapTest, v 0.1 2019/9/5 10:38 刘欣武 Exp$
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(2);
        list.add(8);
        list.add(5);
        list.add(1);
        HashMap<String,String> map = new HashMap<>();
        ThreadPoolUtil.execute(()-> {

        });

        list.sort((a,b)->b-a);
    }


}


