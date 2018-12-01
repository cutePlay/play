package com.cute.play.drama.config;

import java.util.List;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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
@ConfigurationProperties("cors")
@ConditionalOnProperty("cors.enable")
public class CorsConfig {
    private Boolean enable;
    private List<String> origin;
    public static final String ANY = "*";
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration config = new RegExCorsConfiguration();
        config.setAllowedOrigins(this.getOrigin());
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        return config;
    }

    static class RegExCorsConfiguration extends CorsConfiguration{
        @Override
        public String checkOrigin(String requestOrigin) {
            if (!StringUtils.hasText(requestOrigin)) {
                return null;
            } else if (ObjectUtils.isEmpty(super.getAllowedOrigins())) {
                return null;
            } else if (super.getAllowedOrigins().contains(ANY)) {
                return super.getAllowCredentials().equals(Boolean.TRUE) ? requestOrigin: ANY ;
            } else {
                for(String allowedOrigin:super.getAllowedOrigins()){
                    if(Pattern.compile(allowedOrigin).matcher(requestOrigin).matches()){
                        return requestOrigin;
                    }
                }
                return null;
            }
        }
    }
}
