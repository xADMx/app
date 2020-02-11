package com.example.chess.app.config;

import org.aspectj.lang.Aspects;
import org.my.MonitoringAspect;
import org.my.orm.LogClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public MonitoringAspect getBeanPostProcessor(){
        //return  Aspects.aspectOf(MonitoringAspect.class);
        return new MonitoringAspect();
    }


}
