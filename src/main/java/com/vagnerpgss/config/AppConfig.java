package com.vagnerpgss.config;

import com.vagnerpgss.service.defs.DefaultConsumersService;
import com.vagnerpgss.service.interfaces.ConsumersService;
import com.vagnerpgss.service.defs.DefaultParallelProcessorService;
import com.vagnerpgss.service.interfaces.ParallelProcessorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    ConsumersService getDefaultConsumersService() {
        return new DefaultConsumersService();
    }

    @Bean
    ParallelProcessorService getDeafultParallelProcessorService() {
        return new DefaultParallelProcessorService(getDefaultConsumersService());
    }
}
