package com.example.chess.app.config;

import org.my.MonitoringAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Инициализируем наш Aspect в Spring.
     * @return MonitoringAspect
     */
    @Bean
    public MonitoringAspect getBeanPostProcessor(){
        return new MonitoringAspect();
    }


}
