package com.liuxinwu.test;

import com.liuxinwu.test.EnumFun.Human;
import com.liuxinwu.test.FactoryFun.LiuxinwuFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Test {

    public static void main(String[] args){

//        LinkedHashMap<Integer,List<Integer>> resultMap = new LinkedHashMap<>();
//        for(int i=0;i<100;i++){
//            if(i==47){
//                List<Integer> list = new ArrayList<>();
//                for(int j=i+1;j<100;j++){
//                    list.add(j);
//                    i = j;
//                    if(j>61){
//                        break;
//                    }
//                    System.out.println("i="+i);
//                }
//                resultMap.put(i,list);
//            }
//        }
//
        String name = "liuxinwu";
//        if("liuxinwu".equals(name)){
//            System.out.println("11111");
//        }else if("lizhipeng".equals(name)){
//            System.out.println("22222");
//        }else if("songbei".equals(name)){
//            System.out.println("33333");
//        }else if("xiaolong".equals(name)){
//            System.out.println("44444");
//        }else{
//            System.out.println("55555");
//        }
//
//        //枚举来写
//        Human.valueOf(name).say();

        //工厂来做
        LiuxinwuFactory.getMan(name).say();

        //策略模式

    }

}
