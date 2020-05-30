package com.liuxinwu.test.zerenlian;

/**
 * @author 刘欣武
 * @version $Id: MyHandler, v 0.1 2020/5/30 13:49 刘欣武 Exp$
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    public void hand(){
        System.out.println("MyHandler "+name+" working!");
        if(getHandler()!=null){
            getHandler().hand();
        }
    }
}


