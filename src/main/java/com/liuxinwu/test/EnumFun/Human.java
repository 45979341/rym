package com.liuxinwu.test.EnumFun;

public enum Human implements Man{

    liuxinwu{
        @Override
        public void say() {
            System.out.println("11111");
        }
    },
    lizhipeng{
        @Override
        public void say() {
            System.out.println("22222");
        }
    },
    songbei{
        @Override
        public void say() {
            System.out.println("33333");
        }
    },
    xiaolong{
        @Override
        public void say() {
            System.out.println("44444");
        }
    }

}
