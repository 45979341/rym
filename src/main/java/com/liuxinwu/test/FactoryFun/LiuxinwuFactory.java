package com.liuxinwu.test.FactoryFun;

import com.liuxinwu.test.EnumFun.Man;

import java.util.HashMap;
import java.util.Map;

public class LiuxinwuFactory {

    public static Map<String, Man> map = new HashMap<>();

    static{
        map.put("liuxinwu",new LIuxinwu("liuxinwu"));
        map.put("songbei",new Songbei("songbei"));
    }

    public static Man getMan(String name){
        return map.get(name);
    }


}
