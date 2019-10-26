package com.pingan.rym;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@MapperScan(basePackages = "com.pingan.rym.mapper")
public class RymApplication {

	public static void main(String[] args) {
		SpringApplication.run(RymApplication.class, args);
	}
}
