package com.cute.play.drama.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanyuting
 * @since 2018/11/29
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfig {
    private String appId;
    private String appSecret;
    private String token;

}
