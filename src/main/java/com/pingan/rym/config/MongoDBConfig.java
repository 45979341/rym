package com.pingan.rym.config;

import com.pingan.rym.common.Calibre;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: MongoDBConfig, v 0.1 2018/11/19 9:23 刘欣武 Exp$
 */
@Configuration
public class MongoDBConfig {

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, BeanFactory beanFactory){
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        try{
            mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        }catch (NoSuchBeanDefinitionException ignore){
            System.out.println(ignore.getBeanName()+" no such");
        }

        //Don't save _class to MongoDB
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        List<Converter<?,?>> converterList = new ArrayList<>();
//        converterList.add(new CalibreConverter());
//        mappingConverter.setCustomConversions(new CustomConversions(converterList));
        return mappingConverter;
    }

    @ReadingConverter
    static class CalibreConverter implements Converter<Long,Calibre>{
        @Override
        public Calibre convert(Long source){
            for(Calibre item:Calibre.values()){
                if(item.getValue()==source){
                    return item;
                }
            }
            return Calibre.INVALID;
        }
    }

}


