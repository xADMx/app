package com.example.chess.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.my", "com.example.chess.app"})
@EntityScan({"org.my", "com.example.chess.app"})
public class DBConfig {
}
