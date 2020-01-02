package com.liuxinwu.test.FactoryFun;

import com.liuxinwu.test.EnumFun.Man;

public class Songbei implements Man {

    private String name;

    public Songbei(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("you are "+name);
    }
}
