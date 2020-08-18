package com.vagnerpgss.service;

public class DefaultParallelProcessorService implements ParallelProcessorService {

    @Override
    public void processParallelizableFile() {
        System.out.println("Hello from Service");
    }

}