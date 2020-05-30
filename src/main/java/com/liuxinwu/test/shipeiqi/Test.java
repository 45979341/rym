package com.liuxinwu.test.shipeiqi;

/**
 * @author 刘欣武
 * @version $Id: Test, v 0.1 2020/5/30 12:40 刘欣武 Exp$
 */
public class Test {

    public static void main(String[] args){
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();

        Adapter2 adapter2 = new Adapter2(new Source());
        adapter2.method1();
        adapter2.method2();
    }

}


