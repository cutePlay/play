package com.cute.play.drama.config;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author hanyuting
 * @since 2018/11/22
 */
@Getter
@Setter
@Configuration
@ConditionalOnProperty("spring.cors.enable")
@ConfigurationProperties("spring.cors")
public class CorsConfig {
    private Boolean enable;
    private List<String> origin;
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(this.getOrigin());
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        return config;
    }
}
