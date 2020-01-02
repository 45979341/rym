package com.liuxinwu.test.FactoryFun;

import com.liuxinwu.test.EnumFun.Man;

public class LIuxinwu implements Man {

    private String name;

    public LIuxinwu(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("I am "+name);
    }
}
