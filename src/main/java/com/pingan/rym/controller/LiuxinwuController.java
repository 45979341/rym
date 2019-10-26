package com.pingan.rym.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author 刘欣武
 * @version $Id: LiuxinwuController, v 0.1 2018/8/21 14:53 刘欣武 Exp$
 */
@RestController
@RequestMapping("/hello")
@Api("LiuXinwuController")
public class LiuxinwuController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/liuxinwu")
    @ApiOperation(value="添加10个对象")
    public String sayHello(){
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name","fuck"+i);
            map.put("date",new Date());
            list.add(map);
        }
        mongoTemplate.insert(list,"testtable");
        return "Welcome to springboot Liuxinwu";
    }



}


