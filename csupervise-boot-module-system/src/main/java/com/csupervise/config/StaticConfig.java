package com.csupervise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 设置静态参数初始化
 */
@Configuration
public class StaticConfig {

    @Value("${csupervise.sms.accessKeyId}")
    private String accessKeyId;

    @Value("${csupervise.sms.accessKeySecret}")
    private String accessKeySecret;



    @Bean
    public void initStatic() {

    }
}
