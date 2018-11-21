package com.cute.play.drama;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hanyuting
 * @since 2018/11/16
 */
@SpringBootApplication
public class DramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DramaApplication.class);
    }
}
