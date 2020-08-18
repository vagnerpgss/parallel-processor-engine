package com.vagnerpgss.application;

import com.vagnerpgss.service.DefaultParallelProcessorService;
import com.vagnerpgss.service.ParallelProcessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParallelProcessorStandaloneApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ParallelProcessorStandaloneApplication.class, args);
    }
    @Bean
    public ParallelProcessorService getService(){
        return new DefaultParallelProcessorService();
    }

    @Override
    public void run(String... args) throws Exception {
        getService().processParallelizableFile();
    }
}