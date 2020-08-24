package com.vagnerpgss.config;

import com.vagnerpgss.service.DefaultConsumersService;
import com.vagnerpgss.service.ConsumerProducerService;
import com.vagnerpgss.processor.DefaultParallelProcessorService;
import com.vagnerpgss.processor.ParallelProcessorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    ConsumerProducerService getDefaultConsumersService() {
        return new DefaultConsumersService();
    }

    @Bean
    ParallelProcessorService getDeafultParallelProcessorService() {
        return new DefaultParallelProcessorService(getDefaultConsumersService());
    }
}
