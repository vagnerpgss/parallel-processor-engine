package com.vagnerpgss;

import com.vagnerpgss.processor.ParallelProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParallelProcessorRunner implements CommandLineRunner {

    @Autowired
    private ParallelProcessorService parallelProcessorService;

    public static void main(String[] args) {
        SpringApplication.run(ParallelProcessorRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        parallelProcessorService.processParallelizableFile("/home/vagner/dev/arquivoParalelizavel.txt");
    }
}