package com.liuxinwu.test.zerenlian;

/**
 * @author 刘欣武
 * @version $Id: Test, v 0.1 2020/5/30 13:53 刘欣武 Exp$
 */
public class Test {

    public static void main(String[] args){
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        MyHandler h4 = new MyHandler("h4");

        h1.setHandler(h2);
        h2.setHandler(h3);
        h3.setHandler(h4);

        h1.hand();
    }
}


