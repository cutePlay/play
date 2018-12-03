package com.cute.play.drama.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanyuting
 * @since 2018/11/30
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "play")
public class PlayConfig {
    private String frontUrl;
    private String callbackUrl;
}
