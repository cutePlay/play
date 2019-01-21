package com.cute.play.drama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hanyuting
 * @since 2018/11/16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DramaApplication.class);
    }
}
