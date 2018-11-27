package com.cute.play.drama.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Configuration
@MapperScan("com.cute.play.drama.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {
    @Bean
    public ISqlInjector logicSqlInjector(){
        return new LogicSqlInjector();
    }
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
