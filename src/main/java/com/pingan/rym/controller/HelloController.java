package com.pingan.rym.controller;

import com.pingan.rym.dto.PersonDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘欣武
 * @version $Id: HelloController, v 0.1 2018/8/21 11:25 刘欣武 Exp$
 */
@RestController
@RequestMapping("/hello")
@Api("swaggerDemoController相关的api")
public class HelloController {
    //http://localhost:8080/swagger-ui.html swagger地址

    @GetMapping("/world")
    @ApiOperation(value="say hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/world2")
    @ApiOperation(value="say hello2")
    public String sayHello2(@Validated PersonDTO person){

        return "Hello World";
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/addDate")
    @ApiOperation(value="添加Date类型日期")
    public String addDate(
            @RequestParam(required = true)@ApiParam(required = true,value = "20180101") String date) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date d = format.parse(date);
        Map<String,Object> map = new HashMap<>();
        map.put("inputDate",d);
        mongoTemplate.insert(map,"testtable");
        return date;
    }

    @GetMapping("/find")
    @ApiOperation(value="测试Criteria")
    public List<Map> findCustomer(){
        Query query = new BasicQuery(new Document());
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("name").in(new String[]{"liuxinwu","fuck5"}),
                Criteria.where("name").in(new String[]{"fuck6","fuck7"}));
        query.addCriteria(criteria);
        return mongoTemplate.find(query,Map.class,"testtable");
    }


}


