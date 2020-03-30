package com.liuxinwu.test.goujianzhe;

/**
 * @author 刘欣武
 * @version $Id: ResultMap, v 0.1 2020/3/30 21:38 刘欣武 Exp$
 */
public class ResultMap {

    private int code;
    private String msg;
    private Object data;

    private ResultMap(Builder builder){
        this.code = builder.code;
        this.msg = builder.msg;
        this.data = builder.data;
    }

    public static class Builder{
        private int code;
        private String msg;
        private Object data;

        public Builder(int code) {
            this.code = code;
        }

        public Builder setMsg(String msg){
            this.msg = msg;
            return this;
        }

        public Builder setData(Object data){
            this.data = data;
            return this;
        }

        public ResultMap build(){
            return new ResultMap(this);
        }
    }


    public static void main(String[] args){
        ResultMap resultMap = new Builder(200).setMsg("success").setData("invoke ok").build();
    }

}


