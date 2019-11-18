package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author matthew
 * @date 2019.03.17
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zj.system.model.mapper"})
public class JwApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwApplication.class, args);
    }
}
