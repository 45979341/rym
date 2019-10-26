package com.pingan.rym.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: JsonUtil, v 0.1 2019/3/25 14:59 刘欣武 Exp$
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //pojo to json
    public static String ObjectToJson(Object data){
        try{
            String string = MAPPER.writeValueAsString(data);
            return string;
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    //json to pojo
    public static <T> T jsonToPojo(String json,Class<T> beanType){
        try{
            T t = MAPPER.readValue(json,beanType);
            return t;
        }catch (JsonParseException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    //json转成pojo对象的List
    public static <T> List<T> jsonToList(String jsonData,Class<T> beanType){
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try{
            List<T> list = (List<T>)MAPPER.readValue(jsonData, javaType);
            return list;
        }catch (JsonParseException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}


