package com.cute.play.drama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hanyuting
 * @since 2018/11/16
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class DramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DramaApplication.class);
    }
}
