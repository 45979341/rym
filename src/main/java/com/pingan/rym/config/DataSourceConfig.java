//package com.pingan.rym.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//
///**
// * @author 刘欣武
// * @version $Id: DataSourceConfig, v 0.1 2019/6/25 16:01 刘欣武 Exp$
// */
//@Configuration
//public class DataSourceConfig {
//
//    /**
//     * 创建test1的DataSource实例
//     * @return
//     */
//    @Primary //配置一个主连接
//    @Bean(name = "test1DataSource")
//    @Qualifier("test1DataSource")
//    @ConfigurationProperties(prefix="test1.spring.datasource")
//    public DataSource test1DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * 创建test2的DataSource实例
//     * @return
//     */
//    @Bean(name = "test2DataSource")
//    @Qualifier("test2DataSource")
//    @ConfigurationProperties(prefix="test2.spring.datasource")
//    public DataSource test2aryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//}
//
//
