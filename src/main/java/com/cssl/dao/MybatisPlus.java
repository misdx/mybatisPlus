package com.cssl.dao;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlus {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor().setOverflow(true);
    }
}
