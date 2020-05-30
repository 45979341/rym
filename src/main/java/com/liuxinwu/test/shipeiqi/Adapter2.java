package com.liuxinwu.test.shipeiqi;


/**
 * @author 刘欣武
 * @version $Id: Adapter2, v 0.1 2020/5/30 12:38 刘欣武 Exp$
 */
public class Adapter2 implements Sourceable {

    private Source source;

    public Adapter2(Source source){
        this.source = source;
    }

    public void method1(){
        source.method1();
    }

    public void method2(){
        System.out.println("adapter2 invoke method2....");
    }
}


